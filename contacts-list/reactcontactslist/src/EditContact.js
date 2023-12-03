import React from 'react';
import { useState } from 'react';
import Button from 'react-bootstrap/Button';
import ButtonGroup from 'react-bootstrap/ButtonGroup';
import Table from 'react-bootstrap/Table';
import Form from 'react-bootstrap/Form';
import Modal from 'react-bootstrap/Modal';
import './App.css';

const EditContact = (props) => {
  	const [show, setShow] = useState(false);

  	const handleClose = () => setShow(false);
  	const handleShow = () => setShow(true);
  	const handleSelect = () => props.onSelectKey;
  	const handleRowSelect = (e, rowKey) => {
		props.onContactSelect(rowKey);  
	}; 
  	
//  	"id":"da897acd-5bcd-11ee-96d4-98e743472334","lastName":"Bloom","firstName":"John","preferredFirstName":"","middleNameOrInitial":"","suffix":"","identifier":"1"
//                        		<Button size="sm" color="primary" tag={Link} to={"/clients/" + client.id}>Edit</Button>
//                        		<Button size="sm" color="danger" onClick={() => this.remove(client.id)}>Delete</Button>

	return (
	<>
    	<Button variant="primary" onClick={handleShow}>
    		Create New Contact
  		</Button>
            <Table className="mt-4" striped hover>
            	<thead>
                <tr>
                	<th width="30%">Last Name</th>
                    <th width="30%">First Name</th>
                    <th width="40%">Actions</th>
                </tr>
                </thead>
                <tbody>
                {props.contactSelections.map((contact => {
            		return <tr key={contact.id} onClick={(e) => handleRowSelect(e, contact.id)} >
                		<td style={{whiteSpace: 'nowrap'}}>{contact.lastName}</td>
                		<td>{contact.firstName}</td>
                		<td>
                    		<ButtonGroup>
                        		<Button size="sm" variant="primary" >Edit</Button>
                        		<Button size="sm" variant="danger" >Delete</Button>
                    		</ButtonGroup>
                		</td>
            		</tr>
        		}))}
                </tbody>
            </Table>
  		<Modal 
  			show={show} 
  			onHide={handleClose}
        	backdrop="static"
        	keyboard={false}
  		>
    		<Modal.Header closeButton>
      			<Modal.Title>Create New Contact</Modal.Title>
    		</Modal.Header>
    		<Modal.Body>
      			<Form>
        			<Form.Group className="mb-3" controlId="editContactFirstName">
          				<Form.Label>First Name*</Form.Label>
          				<Form.Control
            				type="text"
            				placeholder="First Name"
            				autoFocus
          				/>
        			</Form.Group>
        			<Form.Group className="mb-3" controlId="editContactPreferredName">
          				<Form.Label>Preferred Name</Form.Label>
          				<Form.Control
            				type="text"
            				placeholder="Preferred Name"
          				/>
          				<Form.Text className="text-muted">
                       		Preferred version of first name or nickname
    					</Form.Text>
        			</Form.Group>
        			<Form.Group className="mb-3" controlId="editContactMiddleName">
          				<Form.Label>Middle Name or Initial</Form.Label>
          				<Form.Control
            				type="text"
            				placeholder="Middle Name or Initial"
          				/>
        			</Form.Group>
        			<Form.Group className="mb-3" controlId="editContactLastName">
          				<Form.Label>Last Name*</Form.Label>
          				<Form.Control
            				type="text"
            				placeholder="Last Name"
          				/>
        			</Form.Group>
        			<Form.Group className="mb-3" controlId="editContactSuffix">
          				<Form.Label>Suffix</Form.Label>
          				<Form.Control
            				type="text"
            				placeholder="Suffix"
          				/>
          				<Form.Text className="text-muted">
                       		(e.g., Sr, Jr, III, etc)
    					</Form.Text>
        			</Form.Group>
        			<Form.Group className="mb-3" controlId="editContactIdentifier">
          				<Form.Label>Identifier</Form.Label>
          				<Form.Control
            				type="text"
            				placeholder="Identifier"
            				value="default"
          				/>
          				<Form.Text className="text-muted">
                       		Used to distinguish between duplicates
    					</Form.Text>
        			</Form.Group>
        		</Form>
               	<p class="font-italic">*Required</p>
    		</Modal.Body>
    		<Modal.Footer>
      			<Button variant="secondary" onClick={handleClose}>
        			Close
      			</Button>
      			<Button variant="primary" onClick={handleClose}>
        			Create
      			</Button>
    		</Modal.Footer>
  		</Modal>
	</>
	);
}

export default EditContact;
import React from 'react';
import { useState } from 'react';
import Button from 'react-bootstrap/Button';
import Form from 'react-bootstrap/Form';
import Modal from 'react-bootstrap/Modal';
import './App.css';

const EditContact = (props) => {
  	const [show, setShow] = useState(false);

  	const handleClose = () => setShow(false);
  	const handleShow = () => setShow(true);
  	const handleSelect = () => props.onSelectKey;

	return (
	<>
    	<Button variant="primary" onClick={handleShow}>
    		Create New Contact
  		</Button>
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
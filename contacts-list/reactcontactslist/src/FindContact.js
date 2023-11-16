import React from 'react';
import { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import Button from 'react-bootstrap/Button';
import Form from 'react-bootstrap/Form';
import Modal from 'react-bootstrap/Modal';
import './App.css';

const FindContact = (props) => {	
	
  	const [show, setShow] = useState(false);

  	const navigate = useNavigate();

  	const handleClose = () => setShow(false);
  	const handleShow = () => setShow(true);
  	
  	const handleSelect = () => props.onSelectKey;

  	// TODO create function to show all contacts
  	const handleShowAll = () => {
		handleSelect('contacts');
		navigate('/list');
	};
	
    return (
    <>
    	<Button variant="primary" onClick={handleShow}>
    		Find Contact
  		</Button>
    	<Button variant="primary" onClick={handleShowAll}>
    		Show All Contacts
  		</Button>
  		<Modal 
  			show={show} 
  			onHide={handleClose}
        	backdrop="static"
        	keyboard={false}
  		>
    		<Modal.Header closeButton>
      			<Modal.Title>Find Contact</Modal.Title>
    		</Modal.Header>
    		<Modal.Body>
      			<Form>
        			<Form.Group className="mb-3" controlId="findContactName">
          				<Form.Label>Contact Name</Form.Label>
          				<Form.Control
            				type="text"
            				placeholder="Contact Name"
            				autoFocus
          				/>
          				<Form.Text className="text-muted">
                       		Any of (last name, first name + last name, preferred name + last name), full or partial
    					</Form.Text>
        			</Form.Group>
    			</Form>
    		</Modal.Body>
    		<Modal.Footer>
      			<Button variant="secondary" onClick={handleClose}>
        			Close
      			</Button>
      			<Button variant="primary" onClick={handleClose}>
        			Find
      			</Button>
    		</Modal.Footer>
    	</Modal>
	</>
    );

}

export default FindContact;

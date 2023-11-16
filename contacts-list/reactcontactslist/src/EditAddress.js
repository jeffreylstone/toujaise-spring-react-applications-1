import React from 'react';
import { useState } from 'react';
import Button from 'react-bootstrap/Button';
import Form from 'react-bootstrap/Form';
import Modal from 'react-bootstrap/Modal';
import './App.css';

const EditAddress = (props) => {
  	const [show, setShow] = useState(false);

  	const handleClose = () => setShow(false);
  	const handleShow = () => setShow(true);
  	
//CREATE TABLE `address` (
//  `id` uuid NOT NULL,
//  `address1` varchar(127) DEFAULT NULL,
//  `address2` varchar(127) DEFAULT NULL,
//  `city` varchar(127) DEFAULT NULL,
//  `state_province` varchar(127) DEFAULT NULL,
//  `country_code` uuid DEFAULT NULL,
//  `postal_code` varchar(127) DEFAULT NULL,
//  PRIMARY KEY (`id`)
//) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;  	
  	
// country code and state/province should be drop-down lists...  	
  	

  	return (
    <>
    	<Button variant="primary" onClick={handleShow}>
    		Create New Address
  		</Button>
  		<Modal 
  			show={show} 
  			onHide={handleClose}
        	backdrop="static"
        	keyboard={false}
  		>
    		<Modal.Header closeButton>
      			<Modal.Title>Create New Address</Modal.Title>
    		</Modal.Header>
    		<Modal.Body>
      			<Form>
        			<Form.Group className="mb-3" controlId="editAddressLine1">
          				<Form.Label>Address Line 1*</Form.Label>
          				<Form.Control
            				type="text"
            				placeholder="Address Line 1"
            				autoFocus
          				/>
        			</Form.Group>
        			<Form.Group className="mb-3" controlId="editAddressLine2">
          				<Form.Label>Address Line 2</Form.Label>
          				<Form.Control
            				type="text"
            				placeholder="Address Line 2"
          				/>
        			</Form.Group>
        			<Form.Group className="mb-3" controlId="editAddressCity">
          				<Form.Label>City*</Form.Label>
          				<Form.Control
            				type="text"
            				placeholder="City"
          				/>
        			</Form.Group>
        			<Form.Group className="mb-3" controlId="editAddressCountry">
          				<Form.Label>Country*</Form.Label>
          				<Form.Control
            				type="text"
            				placeholder="Country"
          				/>
        			</Form.Group>
        			<Form.Group className="mb-3" controlId="editAddressStateProvince">
          				<Form.Label>State/Province</Form.Label>
          				<Form.Control
            				type="text"
            				placeholder="State/Province"
          				/>
        			</Form.Group>
        			<Form.Group className="mb-3" controlId="editAddressPostalCode">
          				<Form.Label>Postal Code*</Form.Label>
          				<Form.Control
            				type="text"
            				placeholder="Postal Code"
          				/>
        			</Form.Group>
        			<p>*Required</p>
        		</Form>
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
};

export default EditAddress;
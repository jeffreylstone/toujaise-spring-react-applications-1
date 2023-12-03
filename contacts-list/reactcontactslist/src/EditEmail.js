import React from 'react';
import { useState } from 'react';
import Button from 'react-bootstrap/Button';
import Form from 'react-bootstrap/Form';
import Modal from 'react-bootstrap/Modal';
import './App.css';

const EditEmail = (props) => {
	
	const usageTypes = props.usageSelections;
	
	const [data, setData] = useState({});

  	const [show, setShow] = useState(false);

    const updateData = (e) => {
        setData({
            ...data,
            [e.target.name]: e.target.value
        });
    };

    const submit = (e) => {
        e.preventDefault();
        console.log(data);
        alert(JSON.stringify(data));
    };
    	
  	const handleClose = () => setShow(false);
  	const handleShow = () => setShow(true);
  	
  	return (
    <>
    	<p>{props.contactSelection}</p>
    	<Button variant="primary" onClick={handleShow}>
    		Create New Email Address
  		</Button>
  		<Modal 
  			show={show} 
  			onHide={handleClose}
        	backdrop="static"
        	keyboard={false}
  		>
    		<Modal.Header closeButton>
      			<Modal.Title>Create New Email Address</Modal.Title>
    		</Modal.Header>
    		<Modal.Body>
      			<Form>
        			<Form.Group className="mb-3" controlId="editEmailAddress">
          				<Form.Label>Email Address*</Form.Label>
          				<Form.Control
          					name="emailAddress"
            				type="text"
            				placeholder="Email Address"
            				onChange={updateData}
            				autoFocus
          				/>
        			</Form.Group>
        			<Form.Group className="mb-3" controlId="editEmailUsage">
          				<Form.Label>Usage</Form.Label>
          				<Form.Select name="emailUsage" onChange={updateData}>
          					{usageTypes.map((type) => <option value={type.attrUsageCd}>{type.description}</option>)}
          				</Form.Select>
        			</Form.Group>
        			<p>*Required</p>
        		</Form>
        	</Modal.Body>
    		<Modal.Footer>
      			<Button variant="secondary" onClick={handleClose}>
        			Close
      			</Button>
      			<Button variant="primary" onClick={submit}>
        			Create
      			</Button>
    		</Modal.Footer>
        </Modal>
	</>   
	);
};

export default EditEmail;
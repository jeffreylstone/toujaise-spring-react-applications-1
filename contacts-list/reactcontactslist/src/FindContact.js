import React from 'react';
import { useState } from 'react';
import Button from 'react-bootstrap/Button';
import Form from 'react-bootstrap/Form';
import Modal from 'react-bootstrap/Modal';
import './App.css';

const FindContact = (props) => {	
	
  	const [show, setShow] = useState(false);

	const [data, setData] = useState({});

    const updateData = (e) => {
        setData({
            ...data,
            [e.target.name]: e.target.value
        });
    };

    const submit = (e) => {
        e.preventDefault();
        console.log(data);
        setShow(false);
        if (data.searchText !== undefined) {
			if (data.searchText.trim() !== '') {
				handleSelect('contacts');
				handleContactSearch(data.searchText);
			}
		}
    };

  	const handleClose = () => setShow(false);
  	const handleShow = () => setShow(true);
  	
  	const handleSelect = (k) => props.onKeySelect(k);
  	
  	const handleContactsUpdate = (id) => props.onContactsUpdate(id);

  	const handleContactSearch = (st) => props.onContactSearch(st);

  	const handleShowAll = () => {
		handleSelect('contacts');
		handleContactsUpdate('00000000-0000-0000-0000-000000000000');
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
          					name="searchText"
            				type="text"
            				placeholder="Contact Name"
            				onChange={updateData}
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
      			<Button variant="primary" onClick={submit}>
        			Find
      			</Button>
    		</Modal.Footer>
    	</Modal>
	</>
    );

}

export default FindContact;

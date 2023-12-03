import React from 'react';
import { useEffect, useState } from 'react';
import Button from 'react-bootstrap/Button';
import Form from 'react-bootstrap/Form';
import Modal from 'react-bootstrap/Modal';
import './App.css';

const EditAddress = (props) => {
	
	const [countryCodes, setCountryCodes] = useState([]);

	const [stateProvinceCodes, setStateProvinceCodes] = useState([]);

	const [stateProvinceCodesForCountry, setStateProvinceCodesForCountry] = useState([]);

	const [countrycodedata, setCountrycodedata] = useState({});

	const [stateprovincedata, setStateprovincedata] = useState({});

  	const [show, setShow] = useState(false);
  	
  	const [defaultCountry, setDefaultCountry] = useState('US');

	useEffect(() => {
		fetch(`/services/attributes/countryCodes`)
			.then(response => response.json())
			.then(data => setCountryCodes(data));
		fetch(`/services/attributes/stateProvince`)
			.then(response => response.json())
			.then((data) => {
				setStateProvinceCodes(data);
				setStateProvinceCodesForCountry(data.filter(el => el.alpha2 === 'US'));
			});
	}, []);

    const updateCountryCodeData = (e) => {
        setCountrycodedata({
            ...countrycodedata,
            [e.target.name]: [e.target.value]
        });
        
        var sp4ctry = stateProvinceCodes.filter(el => el.alpha2 === e.target.value);
         
    	setStateProvinceCodesForCountry(sp4ctry);    	
    };
	
	const updateStateProvinceData = (e) => {
		setStateprovincedata({
			...stateprovincedata,
			[e.target.name]: [e.target.value]	
		});
	};

  	const handleClose = () => setShow(false);

  	const handleShow = () => setShow(true);

  	return (
    <>
    	<p>{props.contactSelection}</p>
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
          				<Form.Select name="addressCountry" onChange={updateCountryCodeData} defaultValue={defaultCountry} >
          					{countryCodes.map((type) => <option value={type.alpha_2}>{type.name}</option>)}
          				</Form.Select>
        			</Form.Group>
        			<Form.Group className="mb-3" controlId="editAddressStateProvince">
          				<Form.Label>State/Province</Form.Label>
          				<Form.Select name="addressStateProvince" onChange={updateStateProvinceData} >
          					{stateProvinceCodesForCountry.map((type) => <option value={type.stateProvCd}>{type.name}</option>)}
          				</Form.Select>
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
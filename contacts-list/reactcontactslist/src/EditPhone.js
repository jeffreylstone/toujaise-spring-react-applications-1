import React from 'react';
import { useEffect, useState } from 'react';
import Button from 'react-bootstrap/Button';
import Form from 'react-bootstrap/Form';
import Modal from 'react-bootstrap/Modal';
import './App.css';

const EditPhone = (props) => {
	
	const usageTypes = props.usageSelections;

	const [countryCodes, setCountryCodes] = useState([]);
	
	const [phoneTypes, setPhoneTypes] = useState([]);

	const [countrycodedata, setCountrycodedata] = useState({});

	const [typedata, setTypedata] = useState({});

	const [usagedata, setUsagedata] = useState({});

  	const [show, setShow] = useState(false);

	useEffect(() => {
		fetch(`/services/attributes/phoneCountryCode`)
			.then(response => response.json())
			.then(data => setCountryCodes(data));
		fetch(`/services/attributes/phoneType`)
			.then(response => response.json())
			.then(data => setPhoneTypes(data));
	}, []);

    const updateCountryCodeData = (e) => {
		var newValue = countryCodes.find(el => el.alpha2 === e.target.value);
		var newCountryCode = newValue.phoneNbrCtryCd;
		
        setCountrycodedata({
            ...countrycodedata,
            [e.target.name]: newCountryCode
        });
    };

    const updateTypeData = (e) => {
        setTypedata({
            ...typedata,
            [e.target.name]: e.target.value
        });
    };

    const updateUsageData = (e) => {
        setUsagedata({
            ...usagedata,
            [e.target.name]: e.target.value
        });
    };

  	const handleClose = () => setShow(false);
  	const handleShow = () => setShow(true);
  	const handleSubmit = () => {
		  alert(JSON.stringify(countrycodedata));
		  alert(JSON.stringify(typedata));
		  alert(JSON.stringify(usagedata));
		  setShow(false);
	};
  	
//CREATE TABLE `phone_number` (
//  `id` uuid DEFAULT NULL,
//  `phone_country_cd` varchar(8) NOT NULL,
//  `phone_nbr` varchar(18) NOT NULL,
//  `phone_nbr_ext` varchar(21) NOT NULL,
//  `phone_type_cd` smallint(6) DEFAULT NULL,
//  `phone_usage_cd` smallint(6) DEFAULT NULL,
//  PRIMARY KEY (`phone_country_cd`,`phone_nbr`,`phone_nbr_ext`),
//  KEY `fk2` (`phone_type_cd`),
//  KEY `fk3` (`phone_usage_cd`),
//  CONSTRAINT `fk2` FOREIGN KEY (`phone_type_cd`) REFERENCES `phone_type_code` (`phone_type_cd`),
//  CONSTRAINT `fk3` FOREIGN KEY (`phone_usage_cd`) REFERENCES `attribute_usage_code` (`attr_usage_cd`)
//) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

//          				<Form.Control
//            				type="text"
//            				placeholder="Phone Country"
//            				autoFocus
//          				/>


// Country, Type, Usage should be drop-downs  	
  	
  	return (
    <>
       	<p>{props.contactSelection}</p>
    	<Button variant="primary" onClick={handleShow}>
    		Create New Phone Number
  		</Button>
  		<Modal 
  			show={show} 
  			onHide={handleClose}
        	backdrop="static"
        	keyboard={false}
  		>
    		<Modal.Header closeButton>
      			<Modal.Title>Create New Phone Number</Modal.Title>
    		</Modal.Header>
    		<Modal.Body>
      			<Form>
        			<Form.Group className="mb-3" controlId="editPhoneCountry">
          				<Form.Label>Phone Country*</Form.Label>
          				<Form.Select name="phoneCountry" onChange={updateCountryCodeData} defaultValue="US" >
          					{countryCodes.map((type) => <option value={type.alpha2}>{type.name}</option>)}
          				</Form.Select>
        			</Form.Group>
        			<Form.Group className="mb-3" controlId="editPhoneNumber">
          				<Form.Label>Phone Number*</Form.Label>
          				<Form.Control
            				type="text"
            				placeholder="Phone Number"
          				/>
        			</Form.Group>
        			<Form.Group className="mb-3" controlId="editPhoneExtension">
          				<Form.Label>Extension</Form.Label>
          				<Form.Control
            				type="text"
            				placeholder="Extension"
          				/>
        			</Form.Group>
        			<Form.Group className="mb-3" controlId="editPhoneType">
          				<Form.Label>Phone Type</Form.Label>
          				<Form.Select name="phoneType" onChange={updateTypeData}>
          					{phoneTypes.map((type) => <option value={type.phoneTypCd}>{type.description}</option>)}
          				</Form.Select>
        			</Form.Group>
        			<Form.Group className="mb-3" controlId="editPhoneUsage">
          				<Form.Label>Usage</Form.Label>
          				<Form.Select name="phoneUsage" onChange={updateUsageData}>
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
      			<Button variant="primary" onClick={handleSubmit}>
        			Create
      			</Button>
    		</Modal.Footer>
        </Modal>
	</>   
	);
};

export default EditPhone;
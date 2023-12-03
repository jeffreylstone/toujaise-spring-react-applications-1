import { Route, Routes, useNavigate } from 'react-router-dom';
import { useEffect, useState } from 'react';
import Layout from './Layout';
import Name from './Name';
import EditContact from './EditContact';
import FindContact from './FindContact';
import EditAddress from './EditAddress';
import EditPhone from './EditPhone';
import EditEmail from './EditEmail';

const MyRoutes = () => {
	
	const [usageTypes, setUsageTypes] = useState([]);
	
  	const [key, setKey] = useState('home');
  	
  	const [contactCollection, setContactCollection] = useState([]);
  	
  	const [contact, setContact] = useState('');

	useEffect(() => {
		fetch(`/services/attributes/attributeUsage`)
			.then(response => response.json())
			.then(data => setUsageTypes(data));
	}, []);
	
	const fetchAll = () => {
		fetch(`/services/contacts/retrieve`)
			.then(response => response.json())
			.then(data => {
				setContactCollection(data);
				setContact('');
				});
	};
	
	// if data contains only one element, setContact to id of that element
	const fetchSubSet = (searchText) => {
		var completeUrl = '/services/contacts/retrieve/filtered/' + encodeURIComponent(searchText);
		fetch(completeUrl)
			.then(response => response.json())
			.then(data => {
				setContactCollection(data);
				setContact('');
				});
	};
	
	const fetchSingle = (id) => {
		fetch(`/services/contacts/retrieve/${id}`)
			.then(response => response.json())
			.then(data => {
				let arrayData = [];
				arrayData.push(data);
				setContactCollection(arrayData);
				setContact(id);
				});
	};
	
	const handleContactCollectionUpdate = (id) => {
		if (id === "00000000-0000-0000-0000-000000000000") {
			alert("handleContactCollectionUpdate - getAll");
			fetchAll();	
		}
		else {
			alert("handleContactCollectionUpdate - getSingle(" + id + ")");
		}
	};
	
	const handleContactSelect = (c) => {
		fetchSingle(c);
	};
  	
	const handleContactSearch = (st) => {
		fetchSubSet(st);
	};
  	
  	const navigate = useNavigate();
  	
  	const handleKeySelect = (k) => {
		setKey(k);	  
	
		switch (k) {
			case 'contacts':
				navigate('/contacts');
				break;
			case 'name':
				navigate('/name');
				break;
			case 'address':
				navigate('/address');
				break;
			case 'phone':
				navigate('/phone');
				break;
			case 'email':
				navigate('/email');
				break;
			case 'home':
			default:
				navigate('/');
				break;
		}
	
	}

    return (
    	<Routes >
    		<Route path="/" element={<Layout selectedKey={key} onKeySelect={handleKeySelect} />}>
				<Route index element={<FindContact onKeySelect={handleKeySelect} onContactsUpdate={handleContactCollectionUpdate} onContactSearch={handleContactSearch} />} />    		
        		<Route path="contacts" element={<EditContact onKeySelect={handleKeySelect} contactSelections={contactCollection} onContactSelect={handleContactSelect} />} />
				<Route path="name" element={<Name onKeySelect={handleKeySelect} contactSelection={contact} />} />
        		<Route path="address" element={<EditAddress onKeySelect={handleKeySelect} usageSelections={usageTypes} contactSelection={contact} />} />
        		<Route path="phone" element={<EditPhone onKeySelect={handleKeySelect} usageSelections={usageTypes} contactSelection={contact} />} />
        		<Route path="email" element={<EditEmail onKeySelect={handleKeySelect} usageSelections={usageTypes} contactSelection={contact} />} />
			</Route>
    	</Routes>
    );
}

export default MyRoutes;

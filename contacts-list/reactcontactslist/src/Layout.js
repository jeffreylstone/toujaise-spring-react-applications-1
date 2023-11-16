import { Outlet, useNavigate } from "react-router-dom";
import { useState } from 'react';
import Tab from 'react-bootstrap/Tab';
import Tabs from 'react-bootstrap/Tabs';

const Layout = (props) => {
//  	const [key, setKey] = useState('home');
  	const [key, setKey] = useState(props.selectedKey);
  	
  	const navigate = useNavigate();
  	  	
  	const handleSelect = (k) => {
		setKey(k);

		switch (k) {
			case 'contacts':
				navigate('/list');
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
	};
	
  	return (
	<>
        <Tabs
          id="layout"
          activeKey={key}
          onSelect={handleSelect}
          className="mb-3"
        >
			<Tab eventKey="home" title="Home">
        		Find | Create
      		</Tab>
      		<Tab eventKey="contacts" title="Contacts">
        		List Contacts (maybe additional tabs for A-Z)
      		</Tab>
      		<Tab eventKey="name" title="Name">
        		Name
      		</Tab>
      		<Tab eventKey="address" title="Address">
        		Address (List) with add/remove, select primary
      		</Tab>
      		<Tab eventKey="phone" title="Phone">
        		Phone Number (List) with add/remove, select primary
      		</Tab>
      		<Tab eventKey="email" title="Email">
        		Email Address (List) with add/remove, select primary
      		</Tab>
		</Tabs>
	
    	<Outlet />
	</>
  	);
};

export default Layout;
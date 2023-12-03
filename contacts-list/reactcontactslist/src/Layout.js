import { Outlet } from "react-router-dom";
import Tab from 'react-bootstrap/Tab';
import Tabs from 'react-bootstrap/Tabs';

const Layout = (props) => {
	
  	return (
	<>
        <Tabs
          id="layout"
          activeKey={props.selectedKey}
          onSelect={props.onKeySelect}
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
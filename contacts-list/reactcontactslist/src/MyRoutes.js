import { Route, Routes } from 'react-router-dom';
import { useState } from 'react';
import Layout from './Layout';
import Name from './Name';
import EditContact from './EditContact';
import FindContact from './FindContact';
import EditAddress from './EditAddress';
import EditPhone from './EditPhone';
import EditEmail from './EditEmail';

//    	<BrowserRouter>
//        </BrowserRouter>

const MyRoutes = () => {
	
  	const [key, setKey] = useState('home');
  	
  	const handleKeySelect = (k) => {
		setKey(k);	  
	}

    return (
    	<Routes >
    		<Route path="/" element={<Layout selectedKey={key} />}>
				<Route index element={<FindContact onSelectKey={handleKeySelect} />} />    		
        		<Route path="list" element={<EditContact onSelectKey={handleKeySelect} />} />
				<Route path="name" element={<Name onSelectKey={handleKeySelect} />} />
        		<Route path="address" element={<EditAddress onSelectKey={handleKeySelect} />} />
        		<Route path="phone" element={<EditPhone onSelectKey={handleKeySelect} />} />
        		<Route path="email" element={<EditEmail onSelectKey={handleKeySelect} />} />
			</Route>
    	</Routes>
    );
}

export default MyRoutes;

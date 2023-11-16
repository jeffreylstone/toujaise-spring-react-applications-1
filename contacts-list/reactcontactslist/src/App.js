import React from 'react';
import { createBrowserRouter, RouterProvider } from "react-router-dom";
import MyRoutes from './MyRoutes';

//  async componentDidMount() {
//    const response = await fetch('/contacts/retrieve');
//    const body = await response.json();
//    this.setState({contacts: body});
//  }
//  state = {
//    contacts: []
//  };
//
//
//  render() {
//    const {contacts} = this.state;
//    return ( <MyRoutes /> );
//  }

const App = () => {
	
	const router = createBrowserRouter([
  		{ path: "*", Component: MyRoutes },
	]);

  	return(
		<RouterProvider router={router} />		  
	); 
		  
};

export default App;

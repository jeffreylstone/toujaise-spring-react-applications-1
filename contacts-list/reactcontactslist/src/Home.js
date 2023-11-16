import React, { Component } from 'react';
import './App.css';

class Home extends Component {
    render() {
        return (
        <>
            <div>
  				<div class="container-fluid">
                	<button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#findContactsModal">Find Contacts</button>
                </div>
            </div>
  			<div class="modal fade" id="findContactsModal" tabindex="-1" aria-labelledby="findContactsModalLabel" aria-hidden="false">
  				<div class="modal-dialog">
    				<div class="modal-content">
      					<div class="modal-header">
        					<h1 class="modal-title fs-5" id="findContactsModalLabel">Find Contact</h1>
        					<button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      					</div>
          				<div class="modal-body">
                        	<div class="mb-3">
                          		<label for="searchTextInput" class="form-label">Contact Name</label>
        						<input type="text" id="searchTextInput" class="form-control" placeholder="Contact Name"></input>
                          		<div id="searchTextHelpBlock" class="form-text">
                            		Any of (last name, first name + last name, preferred name + last name), full or partial
                          		</div>
                        	</div>
                    	</div>
                    	<div class="modal-footer">
        					<button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
        					<button type="button" class="btn btn-primary">Find</button>
      					</div>
    				</div>
  				</div>
			</div>
		</>
        );
    }
}

export default Home;

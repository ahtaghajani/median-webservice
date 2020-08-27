import React, { Component } from 'react';

import './App.css';

import Header from './components/header.js';
import FetchRequest  from './components/fetchRequest.js';

class App extends Component {
  render() {
    return (
      <div>
        <Header />
        <div className="d-flex justify-content-center">
          <FetchRequest />
        </div>
      </div>
    );
  }
}

export default App;

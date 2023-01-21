import React from 'react';
import logo from './logo.svg';
import './App.css';
import { useState } from 'react';

function App() {
  const [accounts, setAccounts] = useState([]);
  async function hi() {
    const response = await fetch('api/v1/account');
    const body = await response.json();
    setAccounts(body);

  }
  hi();
  return (
    <div className="App">
      <header className="App-header">
        <img src={logo} className="App-logo" alt="logo" />
        <p>
          Edit <code>src/App.js</code> and save to reload.
        </p>
        <a
          className="App-link"
          href="https://reactjs.org"
          target="_blank"
          rel="noopener noreferrer"
        >
          Learn React
        </a>
      </header>
      <h2>accounts</h2>
      {accounts.map(account =>
          <div key={account.id}>
            <h2>{account.firstName} ({account.email})</h2>
          </div>
      )}
    </div>
  );
}

export default App;

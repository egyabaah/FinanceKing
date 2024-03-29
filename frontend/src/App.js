import React, { useState } from 'react';
import "bootstrap/dist/css/bootstrap.min.css";
import './App.css';
import { Route, Routes } from 'react-router-dom';
import Home  from './Home';
import { Books } from './pages/books';
import Register from './pages/Register';
import Navbar from './components/Navbar';
import SignIn from './pages/SignIn';

const App = () => {
  const [isLoggedIn, setIsLoggedIn] = useState(true);
  return (
  <>
  <Navbar isLoggedIn= {isLoggedIn} />
  <Routes>
    <Route path="/" element={<Home />}  />
    <Route path="/books" element={<Books />} />
    <Route path="/register" element={<Register />} />
    <Route path="/signin" element={<SignIn />} />
  </Routes>
    </>
  )
}

export default App;
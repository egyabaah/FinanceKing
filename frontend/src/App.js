import React from 'react';
import "bootstrap/dist/css/bootstrap.min.css";
import './App.css';
import { Route, Routes } from 'react-router-dom';
import Home  from './Home';
import { Books } from './pages/books';
import Register from './pages/Register';

const App = () => {
  return (
  <Routes>
    <Route path="/" element={<Home />} />
    <Route path="/books" element={<Books />} />
    <Route path="/register" element={<Register />} />
  </Routes>
  )
}

export default App;
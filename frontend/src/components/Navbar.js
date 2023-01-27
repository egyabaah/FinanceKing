import { useState } from "react";
import { NavLink } from "react-router-dom";
import '../css/Navbar.css';
import { HiMenuAlt3 as Hamburger} from "react-icons/hi" ;
import { HiX } from "react-icons/hi";
// HiMenuAlt3

export default function Navbar(props) {
  const [showNavbar, setShowNavbar] = useState(false)

  const toggleNavItems = () => {
    setShowNavbar(!showNavbar)
  }

 const isLoggedIn = props.isLoggedIn;
 return (
  <nav className="navbar">
   <div className="container">
    <div className="logo">
     <h5>FINANCE</h5>
    </div>
    <div className="menu-icon" onClick={toggleNavItems}>
     {!showNavbar ? <Hamburger
      color="white"
      size={30}
      title="Menu button"
      />: <HiX       
      color="white"
      size={30}
      title="Menu button"/>}
     {/* <h2>Menu</h2> */}
    </div>
    <div className={`nav-elements  ${showNavbar && 'active'}`}>
     <ul>
      <li>
       <NavLink onClick={()=>setShowNavbar(!showNavbar)} to="/">HOME</NavLink>
      </li>
      <li>
       <NavLink onClick={()=>setShowNavbar(!showNavbar)} to="/about">ABOUT US</NavLink>
      </li>
      <li>
       <NavLink onClick={()=>setShowNavbar(!showNavbar)} to="/contact">CONTACT US</NavLink>
      </li>
      {isLoggedIn? 
       [<li>
        <NavLink onClick={()=>setShowNavbar(!showNavbar)} to="/register">SIGN UP</NavLink>
         </li>,
        <li>
         <NavLink onClick={()=>setShowNavbar(!showNavbar)} to ="/signin">SIGN IN</NavLink>
         </li>]
       : <li><NavLink onClick={()=>setShowNavbar(!showNavbar)}></NavLink></li>}
      {/* {isLoggedIn? 
       [<li><NavLink to="/register">SIGN UP</NavLink></li>,
       <li><NavLink to="/register">SIGN UP</NavLink></li>]:<h1>Hello</h1>} */}
     </ul>
    </div>

   </div>
  </nav>
 )
}
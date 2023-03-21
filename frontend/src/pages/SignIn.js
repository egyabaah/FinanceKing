import { useState } from "react";
import "../css/SignIn.css";
import { useNavigate } from "react-router-dom";
import accountService from "../services/accountService";

export default function SignIn () {

 const navigate = useNavigate();
 const [email, setEmail] = useState("");
 const [password, setPassword] = useState("");

 async function handleSubmit(e){
  e.preventDefault();
  let response = await accountService.logIn({email:email, password:password})
  console.log(response);

 }

 return (
  <div className="signin-body">
   <div className="container">
    <div className="form-container">
     <form className="signin-forms" onSubmit={handleSubmit}>
      <div className="signin-logo">
       <img className="" src={ require("../images/logo.png") } alt="Logo" height="45px" width="150px" />
      </div>
      <div className="individual-field-signin">
       <input type="text" value={email} onChange={(event)=>setEmail(event.target.value)} placeholder="Enter your email address" autoComplete="false" id="email" className=""/>
       <label htmlFor="email">Email address</label>
      </div>
      <div className="individual-field-signin">

       <input type="password" value={password} onChange={(event)=>setPassword(event.target.value)} placeholder="Enter your password" autoComplete="false" id="password"/>
       <label htmlFor="password">Password</label>
      </div>
      <div className="password-reset">
       <a href="/" className="">Forgot password?</a>
      </div>
      <div className="signin-btn-div">
       <input type="submit" value="Sign In" className="signin-btn"/>
      </div>
      <div className="divider">
       <span className="textInDivider">or</span>
      </div>
      <div className="signup-btn-div">
       <button className="signup-btn" onClick={()=> navigate("/register")}>Sign Up</button>
      </div>
     </form>
    </div>
   </div>
  </div>
 )

}
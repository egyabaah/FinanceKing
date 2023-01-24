import { useState } from "react";
import '../css/Register.css';
import AccountService from "../services/accountService";
import { useNavigate } from "react-router-dom";


const Register = () => {

 const [firstName, setFirstName] = useState();
 const [lastName, setLastName] = useState();
 const [middleName, setMiddleName] = useState();
 const [email, setEmail] = useState();
 const [phone, setPhone] = useState();
 const [dob, setDob] = useState();
 const [password, setPassword] = useState();
 const [rePassword, setRePassword] = useState();

 function firstNameHandler(event){
  ;
 }

 const navigate = useNavigate();

 async function handleSubmit(){
  let response = await AccountService.create({firstName: firstName, age: 50});
  let gh = response.data;
  // alert(gh);
  return navigate("/");
  
 }
 return(
  <div className="register-body">
   <div className="form-container">
    <form className="register-form" onSubmit={handleSubmit}>
     <div className="cont">
      <fieldset className="individual-field">
       <div className="inner-fieldset">

        <label><span className="label-text">First Name<span id="required">*</span></span><input type="text" value={firstName} onChange={(event)=>setFirstName(event.target.value)} placeholder="First Name" /></label>
        <label><span className="label-text">Last Name<span id="required">*</span></span><input type="text" value={lastName} onChange={(event)=>setLastName(event.target.value)} placeholder="Last Name" /></label>
       </div>
      </fieldset>
      <fieldset className="individual-field">
       <div className="inner-fieldset">
        <label><span className="label-text">Middle Name</span><input type="text" value={middleName} onChange={(event)=>setMiddleName(event.target.value)} placeholder="Middle Name" /> </label>
        <label><span className="label-text">Email<span id="required">*</span></span><input type="email" value={email} onChange={(event)=>setEmail(event.target.value)} placeholder="Email" /> </label>
       </div>
      </fieldset>
      <fieldset className="individual-field">
       <div className="inner-fieldset">
        <label><span className="label-text">Phone Number<span id="required">*</span></span><input type="text" value={phone} onChange={(event)=>setPhone(event.target.value)} placeholder="eg. +2331234567890" /></label>
        <label><span className="label-text">Date of Birth<span id="required">*</span></span><input type="text" value={dob} onChange={(event)=>setDob(event.target.value)} placeholder="eg. 28-10-2023" /></label>
       </div>
      </fieldset>
      <fieldset className="individual-field">
       <div className="inner-fieldset">
        <label><span className="label-text">Password<span id="required">*</span></span><input type="password" value={password} onChange={(event)=>setPassword(event.target.value)} placeholder="Password" /></label>
        <label><span className="label-text">Re-enter Password<span id="required">*</span></span><input type="password" value={rePassword} onChange={(event)=>setRePassword(event.target.value)} placeholder="Re-enter Password" /></label>
       </div>
      </fieldset>
      <fieldset className="individual-field  submit-field">
       <div className="submitbtn-div"><input type="submit" value="Submit" className="submitbtn" /></div>
      </fieldset>
     </div>
    </form>
   </div>

  </div>
 )
}

export default Register;
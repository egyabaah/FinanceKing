import { useEffect, useState } from "react";
import '../css/Register.css';
import AccountService from "../services/accountService";
import { useNavigate } from "react-router-dom";
import { HiOutlineExclamationCircle as ExclaimationSign} from "react-icons/hi";

const Register = () => {

 const dateregexp = /^(?:(?:31(\/|-|\.)(?:0?[13578]|1[02]))\1|(?:(?:29|30)(\/|-|\.)(?:0?[13-9]|1[0-2])\2))(?:(?:1[6-9]|[2-9]\d)?\d{2})$|^(?:29(\/|-|\.)0?2\3(?:(?:(?:1[6-9]|[2-9]\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\d|2[0-8])(\/|-|\.)(?:(?:0?[1-9])|(?:1[0-2]))\4(?:(?:1[6-9]|[2-9]\d)?\d{2})$/;

 const emailregexp = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/

 const phoneregexp = /^[\+]?[(]?[0-9]{3}[)]?[-\s\.]?[0-9]{3}[-\s\.]?[0-9]{4,6}$/

 // if (dateregexp.test(dob)){
 //  return true;
 // }

 const Exclaimation = <ExclaimationSign color="red" size={14} style={{marginTop: -4}} />

 const [windowSize, setWindowSize] = useState([
    window.innerWidth,
    window.innerHeight,
  ]);

  useEffect(() => {
    const handleWindowResize = () => {
      setWindowSize([window.innerWidth, window.innerHeight]);
    };

    window.addEventListener('resize', handleWindowResize);

    return () => {
      window.removeEventListener('resize', handleWindowResize);
    };
  });

  const [width, setWidth] = useState(windowSize[0]);
  useEffect(()=>{
   setWidth(windowSize[0]);
  }, [windowSize])


 const [firstName, setFirstName] = useState("");
 const [lastName, setLastName] = useState("");
 const [middleName, setMiddleName] = useState("");
 const [email, setEmail] = useState("");
 const [phone, setPhone] = useState("");
 const [dob, setDob] = useState("");
 const [password, setPassword] = useState("");
 const [rePassword, setRePassword] = useState("");

 function firstNameHandler(event){
  ;
 }

 const navigate = useNavigate();



 const [fnc, setFnc] = useState(false);
 const [lnc, setLnc] = useState(false);
 // const [mnc, setMnc] = useState(false);
 const [ec, setEc] = useState(false);
 const [pc, setPc] = useState(false);
 const [dobc, setDobc] = useState(false);
 const [pswdc, setPswdc] = useState(false);
 const [rePswdc, setRePswdc] = useState(false);
 const [pswdmatch, setPswdMatch] = useState(false);

 // Checks if all required fields are filled; return true if yes, else false
 function checkRequirements() {
  let result = true;
  if (firstName ==- ""){
   setFnc(true);
   result = false;
  }
  else{
   setFnc(false);
   
  }
  if (lastName === ""){
   setLnc(true);
   result = false;
  }
  else{
   setLnc(false);
   
  }
  if (email === "" || !emailregexp.test(email)){
   setEc(true);
   result = false;
  }
  else{
   setEc(false);
   
  }
  if (phone === "" || !phoneregexp.test(phone)){
   setPc(true);
   result = false;
  }
  else{
   setPc(false);
   
  }
  if (dob === "" || !dateregexp.test(dob)){
   setDobc(true);
   result = false;
  }
  else{
   setDobc(false);
   
  }
  if (password === ""){
   setPswdc(true);
   result = false;
  }
  else{
   setPswdc(false);
   
  }
  if (rePassword === ""){
   setRePswdc(true);
   result = false;
  }
  else{
   setRePswdc(false);
   
  }
  if (password !== rePassword){
   setPswdMatch(true);
   result = false;
  }
  else{
   setPswdMatch(false);
   
  }
  return result;
 }

 // Function to handle form on submission; e is a virtual param
 async function handleSubmit(e){
  // Prevents default behavior of form on submit
  e.preventDefault();
  // Sends form data to backend to create an account; This is just a test but not final implementation
  let meetsRequirements = checkRequirements();
  if (meetsRequirements){

   let response = await AccountService.create({firstName: firstName.trim(), lastName: lastName.trim(), dob: dob.trim(), email: email.trim(), phone: phone.trim(), password: password.trim(), middleName: middleName.trim()!= "" ? middleName.trim(): null});
   // Response from server/ backend
   let message = await response.data;
   // Redirects to homepage with message receive from server
   navigate("/", {
    state: {
     message: message
    }
   });
  }
 }
 return(
  <div className="register-body">
   <div className="form-container">
    <form className="register-form" onSubmit={handleSubmit}>
     <div className="cont">
      <fieldset className="individual-field">
       <div className="inner-fieldset">

        <label><span className="label-text">First Name<span id="required">*</span></span><input type="text" value={firstName} onChange={(event)=>setFirstName(event.target.value)} placeholder="First Name" style={fnc?{borderColor:"red"}:null}/></label>
        {width < 654 ? (fnc? <p className="requirement-text phone-requirement-text">{Exclaimation} Enter first name</p> : null): null}
        <label><span className="label-text">Last Name<span id="required">*</span></span><input type="text" value={lastName} onChange={(event)=>setLastName(event.target.value)} placeholder="Last Name" style={lnc? {borderColor: "red"}: null}/></label>
        {width < 654 ? (lnc? <p className="requirement-text phone-requirement-text">{Exclaimation} Enter last name</p> : null): null}
       </div>
       {width > 654 ? ((lnc || fnc) ? ((fnc && lnc) ? <p className="requirement-text">{Exclaimation} Enter first and last names</p>: (fnc? <p className="requirement-text">{Exclaimation} Enter first name</p> : <p className="requirement-text">{Exclaimation} Enter last name</p>)) : null) : null}
      </fieldset>
      <fieldset className="individual-field">
       <div className="inner-fieldset">
        <label><span className="label-text">Middle Name</span><input type="text" value={middleName} onChange={(event)=>setMiddleName(event.target.value)} placeholder="Middle Name" /> </label>
        <label><span className="label-text">Email<span id="required">*</span></span><input type="email" value={email} onChange={(event)=>setEmail(event.target.value)} placeholder="Email" style={ec? {borderColor: "red"}: null} required/> </label>
        {width < 654 ? (ec? <p className="requirement-text phone-requirement-text">{Exclaimation} Enter email</p> : null): null}
       </div>
       {width > 654 ? (ec? <p className="requirement-text">{Exclaimation} Enter email</p> : null) : null}
      </fieldset>
      <fieldset className="individual-field">
       <div className="inner-fieldset">
        <label><span className="label-text">Phone Number<span id="required">*</span></span><input type="text" value={phone} onChange={(event)=>setPhone(event.target.value)} placeholder="eg. +2331234567890" style={pc? {borderColor: "red"}: null} autoComplete="off"/></label>
        {width < 654 ? (pc? <p className="requirement-text phone-requirement-text">{Exclaimation} Enter phone number</p> : null) : null}
        <label><span className="label-text">Date of Birth<span id="required">*</span></span><input type="text" value={dob} onChange={(event)=>setDob(event.target.value)} placeholder="eg. 28-10-2023" style={dobc ? {borderColor: "red"}: null}/></label>
        {width < 654 ? (dobc? <p className="requirement-text phone-requirement-text">{Exclaimation} Enter date of birth</p> : null) : null}
       </div>
       {width > 654 ? ((pc || dobc) ? ((pc && dobc) ? <p className="requirement-text">{Exclaimation} Enter phone number and date of birth</p>: (pc? <p>{Exclaimation} Enter phone number</p> : <p>{Exclaimation} Enter date of birth</p>)) : null) : null}
      </fieldset>
      <fieldset className="individual-field">
       <div className="inner-fieldset">
        <label><span className="label-text">Password<span id="required">*</span></span><input type="password" value={password} onChange={(event)=>setPassword(event.target.value)} placeholder="Password" style={(pswdc || pswdmatch) ? {borderColor: "red"}: null} autoComplete="off" /></label>
        {width < 654 ? (pswdc ? <p className="requirement-text phone-requirement-text">{Exclaimation} Enter password</p> : null) : null}
        {/* { width < 654 ? <h1>hi</h1> : null} */}
        {/* {width < 654 ? (fnc? <p className="requirement-text phone-requirement-text">Enter first name</p> : null): null} */}
        <label><span className="label-text">Re-enter Password<span id="required">*</span></span><input type="password" value={rePassword} onChange={(event)=>setRePassword(event.target.value)} placeholder="Re-enter Password" style={(!pswdc &&(rePswdc || pswdmatch)) ? {borderColor: "red"}: null} autoComplete="off" /></label>
        {width < 654 ? ((!pswdc && (pswdmatch || rePswdc)) ? (((rePswdc && pswdmatch) || rePswdc) ? <p className="requirement-text phone-requirement-text">{Exclaimation} Confirm password</p> : (pswdmatch? <p className="requirement-text phone-requirement-text">{Exclaimation} Those passwords does not match</p>: null)):null): null }
       </div>
       {width > 654 ? ((pswdc || pswdmatch || rePswdc)? 
        (((pswdc && pswdmatch) || pswdc)? <p className="requirement-text">{Exclaimation} Enter password</p>: ((!pswdc && (pswdmatch || rePswdc)) ? (((rePswdc && pswdmatch) || rePswdc) ? <p className="requirement-text">{Exclaimation} Confirm password</p> : (pswdmatch? <p className="requirement-text ">{Exclaimation} Those passwords does not match</p>: null)):null)) : null) : null}
       {/* {(pswdc || pswdmatch)? ( ((pswdc && pswdmatch) || pswdc)? <p className="requirement-text phone-requirement-text">Enter password</p>: <p className="requirement-text phone-requirement-text">Passwords must match</p>) : null} */}
      </fieldset>
      <fieldset className="individual-field  submit-field">
       <div className="submitbtn-div"><input type="submit" value="Submit" className="submitbtn" onClick={handleSubmit} /></div>
      </fieldset>
     </div>
    </form>
   </div>

  </div>
 )
}

export default Register;
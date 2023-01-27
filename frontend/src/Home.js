import React, { useEffect, useState } from "react";
import AccountService from "./services/accountService";
import { useNavigate, useLocation } from "react-router-dom";

function Home() {

 const [jsonob1, setJsonob1] = useState(); 
 const navigate = useNavigate();
 const location = useLocation();
 async function getAccounts(){
  let response = await AccountService.getAll();
  let jsonob = await response.data;
  setJsonob1(jsonob);
  console.log(jsonob);
  alert(location.state.message);
 }
 useEffect(()=>{
  getAccounts();
 }, [])
 function mmn(){
  navigate("/register")
 }
 return (
  <>
  <h1>Hello, Home</h1>
  <h1>Hello, Home</h1>
  {jsonob1 ? jsonob1.map((account)=>{
   if(account != undefined){

    return <button type="button" key={account.id} onClick={mmn}>{account.firstName}</button>
    // <h1 key={account.id}>{account.firstName}</h1>
   }
  }): null}
  </>
 )
}

export default Home;
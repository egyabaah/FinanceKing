import React, { useEffect, useState } from "react";
import AccountService from "./services/accountService";

function Home() {
 const [jsonob1, setJsonob1] = useState(); 
 async function getAccounts(){
  let response = await AccountService.getAll();
  let jsonob = await response.data;
  setJsonob1(jsonob)
  console.log(jsonob)
 }
 useEffect(()=>{
  getAccounts();
 }, [])
 return (
  <>
  <h1>Hello, Home</h1>
  <h1>Hello, Home</h1>
  {jsonob1 ? jsonob1.map((account)=>{
   if(account != undefined){

    return <h1 key={account.id}>{account.firstName}</h1>
   }
  }): null}
  </>
 )
}

export default Home;
import React, {useState} from "react";
function App(){
    const[count,setCount] = useState(0);
    return(
        <div>
            <h2>Virtual Dom</h2>
            <p>Count: {count}</p>
            <button onClick={()=>setCount(count+1)}>Increment</button>
        </div>
    )

}

===========================================================================================
ProductCard.jsx
import React from "react";

function Productcard({name,price,category}){
    return(
        <div style = {{border:"1px solid white", margin:"10px", padding:"10px"}}>
            <h3>{name}</h3>
            <p>Price: {price}</p>
            <p>Category: {category}</p>
            <button onClick={()=>alert(name+" purchased")}>
                Buy Now
            </button>
        </div>
    );
}
export default Productcard;

App.jsx

import React from "react";
import ProductCard from "./ProductCard";

function App(){
  const products = [
    {id: 1, name:"Laptop", price: 50000, category: "electronice"},
    { id: 2, name: "Mobile", price: 20000, category: "Electronics" },
    { id: 3, name: "Shoes", price: 1500, category: "Fashion" }
  ];

  return (
    <div>
      <h1>Product Listing</h1>
      {products.map(p=>(
        <ProductCard
          key={p.id}
          name={p.name}
          price={p.price}
          category={p.category}
          />
      ))}
    </div>
  );
}
export default App;

======================================================================


import React,{useState, useMemo} from "react";

export default function App(){
  const[products] = useState([
    {name:"Pen", qty:5, price: 30},
    {name:"book", qty:2, price: 50},
    {name:"pencil", qty:3, price: 10}
  ]);

  const[search,setSearch] = useState("");
  const[dark,setDark] = useState(false);

  const total = useMemo(()=>products.reduce((sum,p) => sum +p.qty*p.price,0),[products]);
  
  return(
    <div style={{
      background:dark?"black":"white",
      color:dark?"white":"black",
      padding:20,
      minHeight:"100"
    }}>

      <h2>Inventory Management</h2>
      <button onClick={() => setDark(!dark)}>Toggle Theme</button>
      <br /> <br />

      <input placeholder = "Search Product" value = {search} onChange={e=>setSearch(e.target.value)}></input>
      {products.filter(p=>p.name.toLowerCase().includes(search.toLowerCase()))
      .map(p=><p key = {p.name}>{p.name} - Qty: {p.qty} - Price: {p.price}</p>)}
      
      <h3>Total Value: {total}</h3>
    </div>
  )
}
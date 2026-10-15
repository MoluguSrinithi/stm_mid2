=======================================================================
final code 6

import React, {useState, useEffect} from "react";
import {BrowserRouter, Route, Routes, NavLink} from "react-router-dom";

const data = [
  {id:1, name:"Ravi", email: "ravi@gmail.com", city: "Hyd"},
  { id: 2, name: "Ervin Howell", email: "ervin@example.com", city: "Chennai" },
  { id: 3, name: "Clementine Bauch", email: "clem@example.com", city: "Mumbai" },
  { id: 4, name: "Patricia Lebsack", email: "patricia@example.com", city: "Delhi" },
  { id: 5, name: "Chelsey Dietrich", email: "chelsey@example.com", city: "Pune" }
];

function Users(){
  const[users, setUsers] = useState([]);
  const[loading,setLoading] = useState(true);
  const[error,setError] = useState("");

  useEffect(()=>{
    setTimeout(()=>{
      try{
        setUsers(data);
      }
      catch{
        setError("Failed to load");
      }
      setLoading(false);
    },2000)
  });
  if(loading) return <p>Loading users...</p>;
  if(error) return <p style = {{color:"red"}}>{error}</p>;

  return (
    <>
    <h2>users</h2>
    <table border = "1" cellPadding={8}>
      <thead>
        <tr>
          <th>ID</th><th>Name</th><th>Email</th><th>City</th>
        </tr>
      </thead>
      <tbody>
        {users.map(u=>(
          <tr key={u.id}>
            <td>{u.id}</td>
            <td>{u.name}</td>
            <td>{u.email}</td>
            <td>{u.city}</td>
          </tr>
        ))}
      </tbody>
    </table>
    </>
  )
}

function Home(){
  return<>
  <h2>Home</h2>
  <p>Open users to see data..</p></>
}

export default function App(){
  return(
    <BrowserRouter>
    <nav>
      <NavLink to = "/">Home</NavLink>{" | "}
      <NavLink to= "/users">Users</NavLink>
    </nav>
    <Routes>
      <Route path = "/" element = { <Home />}></Route>
      <Route path = "/users" element = {<Users />}></Route>
    </Routes>
    </BrowserRouter>
  );
}


=======================================================================
final code 4
import React, {useState} from "react";
import {BrowserRouter, Routes, Route, NavLink} from "react-router-dom";

const products = [
  {id: 1, name:"Laptop", price: 50000},
  {id: 2, name:"Headphones", price: 10000},
  {id: 3, name:"watch", price: 4000}
]

export default function App(){
  const [cart,setCart] = useState([]);
  const addToCart = (p) => setCart([...cart,p]);
  return(
    <BrowserRouter>
    <nav>
      <NavLink to="/">Home</NavLink>{" | "}
      <NavLink to="/products">Products</NavLink>{" | "}
      <NavLink to="/cart">Cart({cart.length})</NavLink>{" | "}
      <NavLink to="/contact">contact us</NavLink>{" | "}
    </nav>
    <Routes>
      <Route path="/" element={<h2>Home</h2>}></Route>
      <Route path="/products" element={<Products addToCart={addToCart} />}></Route>
      <Route path="/cart" element={<Cart cart={cart} />}></Route>
      <Route path="/contact" element = {<Contact />}></Route>
    </Routes>
    </BrowserRouter>
  );

  function Products({addToCart}){
    return (
      <div>
        <h2>Products</h2>
        {products.map(p=>(
          <div key = {p.id}>
            <p>{p.name} - Rs.{p.price}</p>
            <button onClick={() => addToCart(p)}>Add to cart</button>
          </div>
        ))}
      </div>
    )
  }
}

function Cart({cart}){
  const total = cart.reduce((sum,item) => sum+item.price,0);
  return (
    <div>
      <h2>Cart</h2>
      {cart.length === 0?(
        <p>Cart is empty</p>
      ):(
        <div>
          {cart.map((item,i) =>(
            <p key = {i}>{item.name} - Rs.{item.price}</p>
          ))}
          <h3>Total: Rs.{total}</h3>
        </div>
      )}
    </div>
  )
}

function Contact(){
  return <h2>Contact page</h2>
}

=======================================================================
final code 5

import React,{useState} from "react";
const config=[
  {name:"Name", label:"Full Name", type:"text", required:"true"},
  {name:"Email", label:"Email", type:"email", required:"true"},
  {name:"age", label:"Age", type:"number", required:"true"},
  {name:"gender", label:"Gender", type:"radio", options:["Male", "Female", "Other"]},
];

export default function App(){
  const[data,setData] = useState({skils:[]});
  const[submitted,setSubmitted] = useState(null);

  function handleChange(e){
    setData({...data, [e.target.name]:e.target.value});
  }

  function handleSubmit(e){
    e.preventDefault();
    setSubmitted(data);
  }

  return(
    <div>
      <h2>Student Registration</h2>
      <form onSubmit={handleSubmit}>
        {config.map(f=>(
          <div key={f.name}>
            <label>{f.label}: </label>

            {f.type === "radio" ?(
              f.options.map(o=>(
                <label key = {o}>
                  <input 
                  type="radio"
                  name={f.name}
                  value={o}
                  onChange={handleChange}
                  ></input>
                  {o}
                </label>
              ))
            ):
            (
              <input
              type={f.name}
              name={f.name}
              required={f.required}
              onChange={handleChange}></input>
            )}
          </div>
        ))}
        <button type = "submit">Submit</button>
      </form>

      {submitted && (
        <div>
          <h3>Submitted Data</h3>
          {config.map(f=>(
            <p key = {f.label}>
              {f.label}: {submitted[f.name]}
            </p>
          ))}
        </div>
      )}
    </div>
  );
}

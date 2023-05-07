import './App.css';
import api from './api/axiosConfig';
import { useEffect, useState } from 'react';

function App() {
  const[movies,setMovies]=useState();

  const getMovies=async()=>{

    try{
    const response=await api.get("http://localhost:8080/api/movies");
    console.log(response.data);
    setMovies(response.data);

    }catch(err){
      console.log(err);
    }

    

  }

  useEffect(()=>{
    getMovies();
  },[])


  return (
    <div className="App">
      
    </div>
  );
}

export default App;

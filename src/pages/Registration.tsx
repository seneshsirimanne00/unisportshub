import React, { FC, useEffect, useState } from 'react';
import Navbar from '../commonComponents/Navbar';
import axiosInstance from '../services/AxiosController';
import { useNavigate } from 'react-router-dom';

const Registration: FC = () => {
  const navigate = useNavigate();

  const [count, setCount] = useState<number>(0);
  const [err, setErr] = useState(false);

  interface LoginData {
    username: string;
    password: string;
  }
  
  const [username, setUsername] = useState('');
  const [password, setPassword] = useState('');



  const handleSubmit = async (e: React.FormEvent) => {
    e.preventDefault();
    const loginData: LoginData = {
      username,
      password,
    };

    const response = await axiosInstance.post('/auth', loginData);
    const translatedData = response.data;
    console.log('Login', translatedData);
    if (response.data.response === "SUCCESS") {
      navigate('/home');
    } else {
      setErr(true);
    }
    
    console.log('Username:', username);
    console.log('Password:', password);
    setUsername('');
    setPassword('');
  };

  return (
    <div className='app-container'
    style={{
      backgroundColor: "#1f1e1e",
      color: "#fff",
      overflow: "hidden",
      backgroundImage: "radial-gradient(rgba(255, 255, 255, 0.171) 2px, transparent 0)",
      backgroundSize: "30px 30px",
      backgroundPosition: "-5px -5px",
    }}>
        <Navbar />
        

      <div className="row red-container" style={{width: "100%", height: "20vh"}}></div>

      <nav>
        <div className="nav nav-tabs" id="nav-tab" role="tablist" style={{paddingLeft: "40%", backgroundColor: "#1d1d1d"}}>
          <button className={`nav-link ${count === 0 ? 'active' : ''}`} id="nav-home-tab" data-bs-toggle="tab" data-bs-target="#nav-home" type="button" role="tab" aria-controls="nav-home" aria-selected="true" onClick={() => setCount(0)}>Student</button>
          <button className={`nav-link ${count === 1 ? 'active' : ''}`} id="nav-profile-tab" data-bs-toggle="tab" data-bs-target="#nav-profile" type="button" role="tab" aria-controls="nav-profile" aria-selected="false" onClick={() => setCount(1)}>Team</button>
          <button className={`nav-link ${count === 2 ? 'active' : ''}`} id="nav-contact-tab" data-bs-toggle="tab" data-bs-target="#nav-contact" type="button" role="tab" aria-controls="nav-contact" aria-selected="false" onClick={() => setCount(2)}>Athlete</button>
        </div>
      </nav>
    <div className="tab-content" id="nav-tabContent">

    { count === 0 && 
      <div className="tab-pane fade show active" id="nav-home" role="tabpanel" aria-labelledby="nav-home-tab">

        <div className="container">
          <form className="login-form" onSubmit={handleSubmit} >
            <p id="login-heading">Student Login</p>
            <div className="login-field">
            <svg className="login-input-icon" xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" viewBox="0 0 16 16">
            <path d="M13.106 7.222c0-2.967-2.249-5.032-5.482-5.032-3.35 0-5.646 2.318-5.646 5.702 0 3.493 2.235 5.708 5.762 5.708.862 0 1.689-.123 2.304-.335v-.862c-.43.199-1.354.328-2.29.328-2.926 0-4.813-1.88-4.813-4.798 0-2.844 1.921-4.881 4.594-4.881 2.735 0 4.608 1.688 4.608 4.156 0 1.682-.554 2.769-1.416 2.769-.492 0-.772-.28-.772-.76V5.206H8.923v.834h-.11c-.266-.595-.881-.964-1.6-.964-1.4 0-2.378 1.162-2.378 2.823 0 1.737.957 2.906 2.379 2.906.8 0 1.415-.39 1.709-1.087h.11c.081.67.703 1.148 1.503 1.148 1.572 0 2.57-1.415 2.57-3.643zm-7.177.704c0-1.197.54-1.907 1.456-1.907.93 0 1.524.738 1.524 1.907S8.308 9.84 7.371 9.84c-.895 0-1.442-.725-1.442-1.914z"></path>
            </svg>
            <input
              autoComplete="off"
              placeholder="Username"
              className="login-input-field"
              type="text"
              value={username}
              onChange={(e) => setUsername(e.target.value)}
            />
            </div>
            <br/>
            <div className="login-field">
            <svg className="login-input-icon" xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" viewBox="0 0 16 16">
            <path d="M8 1a2 2 0 0 1 2 2v4H6V3a2 2 0 0 1 2-2zm3 6V3a3 3 0 0 0-6 0v4a2 2 0 0 0-2 2v5a2 2 0 0 0 2 2h6a2 2 0 0 0 2-2V9a2 2 0 0 0-2-2z"></path>
            </svg>
            <input
              placeholder="Password"
              className="login-input-field"
              type="password"
              value={password}
              onChange={(e) => setPassword(e.target.value)}
            />
            </div>
            {err && <p style={{color: "red", fontSize : "15px", textAlign:"center",paddingTop:"10px"}}> invalid password or username, Please check again!</p>}
            <div className="login-btn">
            <button className="login-button1" type="submit">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Login&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</button>
            <button className="login-button2">Sign Up</button>
            </div>
            <br/>
            <br/>
            <br/>
            <br/>
          </form>
  
        </div>
      </div>
      }

    </div>


    </div>
  );
}

export default Registration;
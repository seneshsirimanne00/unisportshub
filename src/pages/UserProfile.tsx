import React, { useContext, useEffect } from 'react';
import Navbar from '../commonComponents/Navbar';
import { useNavigate } from 'react-router-dom';
import { AuthContext } from '../AuthContext';

function UserProfile() {
  const navigate = useNavigate();
    const { isLoggedIn , userId } = useContext(AuthContext);
  
    useEffect(() => {
      console.log('authcontext',isLoggedIn, userId );
      if (!isLoggedIn) {
        navigate('/');
      }
    }, [isLoggedIn, navigate]);

  return (
    <div className='app-container'>
        <Navbar />
        <div>
          <h1>Welcome to the UserProfile Page!</h1>
            <p>put body here</p>

        </div>

    </div>
  );
}

export default UserProfile;

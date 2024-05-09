import React, { useContext, useEffect } from 'react';
import Navbar from '../commonComponents/Navbar';
import { useNavigate } from 'react-router-dom';
import { AuthContext } from '../AuthContext';

enum UserType {
    Team = 2,
    Council = 3,
    Athlete = 5,
  }

function AdminPage() {

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
          <h1>logged in as a {userId === UserType.Team  &&  "team" } { userId === UserType.Council  &&  "Council" } </h1>
            <p>put body here</p>

        </div>

    </div>
  );
}

export default AdminPage;
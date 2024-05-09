import React, { useContext, useEffect, useState } from 'react';
import { Link } from 'react-router-dom';

import './common.css';
import { AuthContext } from '../AuthContext';

interface NavItem {
  path: string;
  label: string;
}

function Navbar() {
  const { isLoggedIn , userId } = useContext(AuthContext);
  
  return (
    <nav className='navbar-container'>
      <ul className='navbarItems'>
        <li>
          {isLoggedIn && <Link to='/home'>Home</Link>}
        </li>
        <li>
          {isLoggedIn && <Link to='/profile'>Profile</Link>}
        </li>
        <li>
          {isLoggedIn && <Link to='/calender'>Calender</Link>}
        </li>
        <li>
          {isLoggedIn && <Link to='/home#sportscategories-section'>Sports Categories</Link>}
        </li>
        <li>
          {isLoggedIn && <Link to='/results'>Results</Link>}
        </li>
        <li>
          {userId === 2 && <Link to='/admin'>Admin</Link>}
        </li>
      </ul>
    </nav>
  );
}

export default Navbar;

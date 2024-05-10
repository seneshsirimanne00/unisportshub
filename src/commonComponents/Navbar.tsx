import React, { useContext, useEffect, useState } from 'react';
import { Link } from 'react-router-dom';

import './common.css';
import { AuthContext } from '../AuthContext';

interface NavItem {
  path: string;
  label: string;
}

function Navbar() {
  
  return (
    <nav className='navbar-container'>
      <ul className='navbarItems'>
        <li>
          <Link to='/home'>Home</Link>
        </li>
        <li>
          <Link to='/profile'>Profile</Link>
        </li>
        <li>
          <Link to='/results'>Results</Link>
        </li>
        <li>
          <Link to='/blogs'>Blogs</Link>
        </li>
        <li>
          <Link to='/admin'>Admin</Link>
        </li>
      </ul>
    </nav>
  );
}

export default Navbar;

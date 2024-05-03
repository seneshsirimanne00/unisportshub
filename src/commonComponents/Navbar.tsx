import React from 'react';
import { Link } from 'react-router-dom';

import './common.css';

interface NavItem {
  path: string;
  label: string;
}

const navItems: NavItem[] = [
  { path: '/', label: 'Home' },
  { path: '/sportsCategories', label: 'Sports Categories' },
  { path: '/news', label: 'News' },
  { path: '/teamProfiles', label: 'Team Profiles' },
  { path: '/results', label: 'Results' },
  { path: '/resgistration', label: 'Resgistration' },
];

function Navbar() {
  return (
    <nav className='navbar'>
      <ul className='navbarItems'>
        {navItems.map((item) => (
          <li key={item.path}>
            <Link to={item.path}>{item.label}</Link>
          </li>
        ))}
      </ul>
    </nav>
  );
}

export default Navbar;

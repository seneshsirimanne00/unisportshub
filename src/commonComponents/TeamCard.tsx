import React from 'react';

export interface ITeamCardData {
    name: string;
    username: string;
    winnings:number;
    loses:number;
    players:number;
  }
  

  const TeamCard: React.FC<ITeamCardData> = ({ name, username, winnings , loses , players }) => {
  return (
        <div className="team-card">
          <div className="team-card-info">
            <div className="team-card-avatar"></div>
            <div className="team-card-title">{name}</div>
            <div className="team-card-subtitle">{username}</div>
          </div>
            <ul className="team-card-social">
                <li className="team-card-social__item">
                wins = <b>{winnings}</b></li>
                <li className="team-card-social__item">
                Losses = <b>{loses}</b></li>
                <li className="team-card-social__item">
                Played = <b>{players}</b>
                </li>
            </ul>
        </div>
  );
}

export default TeamCard;
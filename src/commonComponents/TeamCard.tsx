import React from 'react';
import TeamModal from './TeamModal';

export interface ITeamCardData {
    id: number;
    name: string;
    username: string;
    winnings:number;
    loses:number;
    players:number;
  }
  

  const TeamCard: React.FC<ITeamCardData> = ({ id, name, username, winnings , loses , players }) => {
  return (
    <div className='col-lg-3 col-md-4 col-sm-6 col-xs-12'>
        <div className="team-card">
          <div className="team-card-info">
            <div className="team-card-avatar"></div>
            <div className="team-card-title">{name}</div>
            <div className="team-card-subtitle">{username}</div>
            <TeamModal id={id} />
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
        </div>
  );
}

export default TeamCard;
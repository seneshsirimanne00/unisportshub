import React from 'react';

export interface IRPerformanceCardData {
    title: string;
    description: string;
  }
  

  const RPerformanceCard: React.FC<IRPerformanceCardData> = ({title, description}) => {
  return (
    <div className="card-g">
    <a className="card1" href="#">
    <p>{title}</p>
    <p className="small">{description}</p>
    <div className="go-corner" >
      <div className="go-arrow">
        →
      </div>
    </div>
  </a>
</div>

  );
}

export default RPerformanceCard;
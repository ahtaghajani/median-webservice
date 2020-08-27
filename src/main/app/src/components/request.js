import React from 'react';


function Request (req) {

  let styles = {
    maxWidth: '700px'
  };


  return (
      <div className="card border-dark bg-light text-dark text-center p-3 mb-3 ml-5 mr-5" style={styles}>
        <div className="card-header">
            <h2>{req.id}</h2>
            {JSON.stringify(req)}
        </div>
      </div>
  );
}

export default Request;

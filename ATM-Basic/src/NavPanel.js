/**
 * Created by jitender on 3/3/17.
 */
import React from 'react';
export default class NavPanel extends React.Component {
  constructor(props) {
    super(props);
  }
  render(){
    return (
      <div className="navPanel">
        counter: {this.props.count}
        <ul>
        <li>Play</li>
        <li>Coldplay</li>
        <li>Linkin Park</li>
        </ul>
      </div>
    );
  }
}

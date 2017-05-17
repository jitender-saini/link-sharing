/**
 * Created by jitender on 3/3/17.
 */
import React from 'react';

export default class Content extends React.Component {
  constructor(props) {
    super(props);
  }

  render(){
    return (
      <div className="content">
        <button onClick={this.props.onClick}>Count Up!!</button>
      </div>
    );
  }
}

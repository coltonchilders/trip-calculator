class Input extends React.Component {
  constructor(props) {
    super(props);
    this.handleChange = this.handleChange.bind(this);
}

  handleChange(event) {
    this.props.setValue(event.target.value);
  }

  render() {
    return (
      <label>
        {this.props.name}
        <input type="text" value={this.props.value} onChange={this.handleChange} />
      </label>
    );
  }
}

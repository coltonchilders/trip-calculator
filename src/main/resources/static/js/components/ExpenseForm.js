class ExpenseForm extends React.Component {
  constructor(props) {
    super(props);
    this.nameChange = this.nameChange.bind(this);
    this.expenseChange = this.expenseChange.bind(this);
    this.state = {name: '', expense: ''}
  }

  componentWillMount() {
    this.pusher = new Pusher(PUSHER_APP_KEY, {
     cluster: PUSHER_CLUSTER_KEY,
     forceTLS: true
    });
    this.channel = this.pusher.subscribe(PUSHER_CHANNEL_NAME);
    this.total = 0;
  }

  componentDidMount() {
    this.channel.bind('add', this.add);
  }

  componentWillUnmount() {
	// Unbind from channel events
    this.channel.unbind();

    // Unsubscribe from the Pusher channel
    this.pusher.unsubscribe(this.channel);

    // Unregister by assign them to an empty function
    this.getProductsSuccess = function() {};
    this.getCartItemsSuccess = function() {};
  }

  nameChange(name) {
    this.setState({name: name})
  }

  expenseChange(expense) {
    this.setState({expense: expense})
  }

  add(item) {
    console.log("add");
    fetch('/add', {
      credentials: 'same-origin',
      method: 'POST',
      headers: {
        'Content-Type': 'application/json'
      },
      body: JSON.stringify({
        id: this.props.product.id,
        quantity: this.state.quantity,
     })
    });
    console.log("add end");
    nameChange("");
    expenseChange("");
  }

  submit() {
    window.location="/result";
  }

  render() {
    return (
      <div className="container">
        <Header  />
        <Input
          name="Name"
          value={this.state.name}
          setValue={this.nameChange} />
        <Input
          name="Total Expenses"
          value={this.state.expense}
          setValue={this.expenseChange} />
        <button type="button" onClick={this.add}>Add</button>
        <br/>
        <button type="button" onClick={this.submit}>Submit</button>
      </div>
    );
  }
}

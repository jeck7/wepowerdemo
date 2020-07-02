import React, {Component} from 'react'
import '../App.css';
import axios from "axios";
import DatePicker from "react-datepicker";
import "react-datepicker/dist/react-datepicker.css";
import Select from 'react-select';
import {API_BASE_URL} from "../constants";

const customertypes = [
    {label: "Mining", value: "mining"},
    {label: "Industrial", value: "industrial"},
    {label: "Commercial company", value: "commercial company"}
];

const producttypes = [
    {label: "Energy", value: "Energy"},
    {label: "LGC", value: "LGC"}
];

export class Searchdata extends Component {
    constructor(props) {
        super(props)
        this.state = {
            calculationdata: [],
            startdate: '',
            enddate: '',
            customertype: '',
            producttype: ''
        }
    }

    changedate = (e) => {
        this.setState({
            startdate: e
        });
    };
    enddate = (e) => {
        this.setState({
            enddate: e
        });
    };

    componentDidMount() {
        axios.get(API_BASE_URL + '/api/history').then(response => {
            console.log(response.data);
            this.setState({
                calculationdata: response.data
            });
        });
    }

    onsubmit = (e) => {
        const data = {
            startDate: this.state.startdate,
            endDate: this.state.enddate,
            customerType: this.state.customertype,
            productType: this.state.producttype
        };
        axios.post(API_BASE_URL + '/api/calculateprice', data).then(response => {
            console.log(response.data);
            this.setState({
                calculationdata: response.data
            });
        });
    }
    handleChangeCustomer = (selectedOption) => {
        this.setState({
            customertype: selectedOption.value
        });
    }

    handleChangeProduct = (selectedOption) => {
        this.setState({
            producttype: selectedOption.value
        });
        // let opt = '';
        // let opt1 = '';
        // if (selectedOption && selectedOption.length > 0) {
        //     opt = selectedOption[0] ? selectedOption[0].value : ''
        //     opt1 = selectedOption[1] != null ? selectedOption[1].value : ''
        //     opt += ',' + opt1
        // }
        // this.setState({
        //     producttype: opt
        // });
    }

    render() {

        return (
            <div>
                <br/> <br/>
                <div className="row">
                    <div className="col-sm-12 btn btn-info">
                        Price calculation service for average energy price in selected period
                    </div>
                </div>
                <br/> <br/> <br/>
                <form onSubmit={this.onsubmit}>
                    <div className="row hdr">
                        <div className="col-sm-2 form-group">
                            <DatePicker className="form-control"
                                        selected={this.state.startdate} placeholderText="Start Date"
                                        showPopperArrow={false}
                                        onChange={this.changedate}/>
                        </div>
                        <div className="col-sm-2 form-group">
                            <DatePicker className="form-control"
                                        selected={this.state.enddate} placeholderText="End Date"
                                        showPopperArrow={false}
                                        onChange={this.enddate}/>
                        </div>
                        <div className="col-sm-2 form-group">
                            <Select options={customertypes} onChange={this.handleChangeCustomer}
                                    placeholder="Customer Type"/>
                        </div>
                        <div className="col-sm-2 form-group">
                            <Select options={producttypes}
                                    onChange={this.handleChangeProduct}
                                    placeholder="Product Type"
                            />
                        </div>

                        <div className="col-sm-3 form-group">
                            <button type="submit" className="btn btn-success">Calculate</button>
                        </div>
                    </div>
                </form>

                <br/> <br/>
                <div className="table">
                    <h4>Search history</h4></div>
                <table className="table">
                    <thead className="thead-dark">
                    <tr>
                        {/*<th scope="col">Id</th>*/}
                        <th scope="col">startDate</th>
                        <th scope="col">endDate</th>
                        <th scope="col">Product Base Price ($/MWh)</th>
                        <th scope="col">Summary Price($/MWh)</th>
                    </tr>
                    </thead>
                    <tbody>
                    {
                        this.state.calculationdata.map((p, index) => {
                            return <tr key={index}>
                                {/*<th scope="row">{p.id}</th>*/}
                                <td>{p.startDate}</td>
                                <td>{p.endDate}</td>
                                <td>{p.productBasePrice}</td>
                                <td>{p.summaryPrice}</td>
                            </tr>
                        })
                    }
                    </tbody>
                </table>
            </div>
        )
    }
}

export default Searchdata
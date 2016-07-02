/**
 * Sample React Native App
 * https://github.com/facebook/react-native
 * @flow
 */

import React, { Component } from 'react';
import {
	AppRegistry,
	StyleSheet,
	Text,
	TouchableOpacity,
	View,
	TextInput,
	ToastAndroid
} from 'react-native';

var SharedPreferences = require('react-native-shared-preferences');

class example extends Component {

	constructor(props){
		super(props)
		this.state = {
			keyToStore: "",
			valueToStore: "",
			keyToGet: ""
		}
	}
	addSharedPreference(){
		SharedPreferences.setItem(this.state.keyToStore,this.state.valueToStore);
		this.setState({
			keyToStore: "",
			valueToStore: ""
		})
		ToastAndroid.show("Added Shared Preference", ToastAndroid.SHORT);
	}
	getSharedPreference(){
		SharedPreferences.getItem(this.state.keyToGet, function(value){
			ToastAndroid.show(value,ToastAndroid.SHORT);
		})
	}

	// TODO : Function to get all the shared preferences
	//getAllSharedPreferences(){
	//	SharedPreferences.getAll(function(value){
	//		console.log(value);
	//		ToastAndroid.show(value,ToastAndroid.SHORT);
	//	})
	//}
	render() {
		return (
			<View style={styles.container}>
				<Text style={styles.heading}> Shared Preferences </Text>
				<View style={styles.box}>
					<TextInput placeholder="Key" placeholderTextColor='#ccc' onChangeText={(keyToStore) => this.setState({keyToStore})} value={this.state.keyToStore} style={styles.textField}/>
					<TextInput placeholder="Value" placeholderTextColor='#ccc' onChangeText={(valueToStore) => this.setState({valueToStore})} value={this.state.valueToStore} style={styles.textField}/>
					<TouchableOpacity onPress={this.addSharedPreference.bind(this)} style={styles.button}>
						<Text style={styles.buttonText}>Store</Text>
					</TouchableOpacity>
				</View>
				<View style={styles.box}>
					<TextInput placeholder="Key" placeholderTextColor="#ccc" onChangeText={(keyToGet) => this.setState({keyToGet})} value={this.state.keyToGet} style={styles.textField}/>
					<TouchableOpacity onPress={this.getSharedPreference.bind(this)} style={styles.button}>
						<Text style={styles.buttonText}>Retrieve</Text>
					</TouchableOpacity>
				</View>
			</View>
		);
	}
}

const styles = StyleSheet.create({
	container: {
		flex: 1,
		justifyContent: 'center',
		alignSelf: 'center'
	},
	box: {
		width: 220,
		backgroundColor: '#fff',
		padding: 10,
		marginBottom: 10
	},
	button: {
		flex: 1,
		padding: 5,
		backgroundColor: '#aaa',
		marginBottom: 10
	},
	buttonText: {
		textAlign: 'center',
		flex: 1
	},
	heading: {
			fontSize: 20,
			textAlign: 'center',
			margin: 10,
		},
		instructions: {
				textAlign: 'center',
				color: '#333333',
				marginBottom: 5,
			},
		textField: {
				width: 200
			}
});

AppRegistry.registerComponent('example', () => example);

<?php
use App\employee;
use App\attendance;

/*
|--------------------------------------------------------------------------
| Application Routes
|--------------------------------------------------------------------------
|
| Here is where you can register all of the routes for an application.
| It's a breeze. Simply tell Laravel the URIs it should respond to
| and give it the controller to call when that URI is requested.
|
*/

Route::get('/', 'WelcomeController@index');

Route::get('home', 'HomeController@index');


Route::get('/employees',function(){
	$emps = employee::all();
	return $emps->toJson();
});



Route::get('/attendance/{id}',function($id){
	$att = attendance::where('emp_id','=',$id)->get();
	return $att->toJson();
});


Route::get('/add/{id}/{first}/{last}/{middle}/{salary}/{proj?}',function($id,$first,$last,$middle,$salary,$proj = null){
	
	$state = false;
	if(is_numeric($salary)){
		if($salary >= 0){
			$emp = new employee;
			$emp->id_number = $id;
			$emp->first_name = $first;
			$emp->last_name = $last;
			$emp->middle_name = $middle;
			$emp->salary = $salary;
			if(!is_null($proj)){
				$emp->project_id = $proj;
			}

			$state = $emp->save();

		}
	}
	return $converted_res = ($state) ? 'true' : 'false';

});











Route::controllers([
	'auth' => 'Auth\AuthController',
	'password' => 'Auth\PasswordController',
]);

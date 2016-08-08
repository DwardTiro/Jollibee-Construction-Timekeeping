<?php
use App\employee;
use App\attendance;
use App\User;


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

function tryLogin($key){

	
	$user = User::where('logkey',$key)->first();
	if(!is_null($user)){

		$datetime1 = new DateTime();
		$datetime2 = new DateTime($user->updated_at);
		$interval = $datetime1->diff($datetime2);
		$elapsed = $interval->format('%i minutes');

		if($elapsed > 5){
			return 0;
		}

		$pass = $user->logkey;
		if($pass == $key){
			$user->touch();
			return 1;
		}
	}

	return 0;
}


Route::get('/', 'WelcomeController@index');

Route::get('home', 'HomeController@index');


Route::post('/login/{user}/{password}',function($user,$password){


	$user = User::where('user',$user)->first();
	if(!is_null($user)){
		$pass = $user->password;
		if( Hash::check($password,$pass)){
			$unhash = str_random(20);
			$unhash = $user->user.$unhash;
			
			$user->logkey = $unhash;
			$user->touch();
			$user->save();
			return response()->json(['key'=>$unhash]);;
		}
	}
	return 0;
});


Route::post('/{key}/employees',function($key){


	$stat = tryLogin($key);
	
	if($stat == 0){
		return 0;
	}

	$emps = employee::all();

	return response()->json($emps);
});



Route::post('/{key}/attendance/{id}',function($key,$id){

	$stat = tryLogin($key);

	if($stat == 0){
		return 0;
	}

	$att = attendance::where('emp_id','=',$id)->get();
	return response()->json($att);
});


Route::post('/{key}/add/{id}/{first}/{last}/{middle}/{salary}/{proj?}',function($key,$id,$first,$last,$middle,$salary,$proj = null){
	
	$stat = tryLogin($key);
	if($stat == 0){
		return 0;
	}


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
	$converted_res = ($state) ? 'true' : 'false';
	return response()->json(["status"=>$converted_res]);
});




Route::controllers([
	'auth' => 'Auth\AuthController',
	'password' => 'Auth\PasswordController',
]);

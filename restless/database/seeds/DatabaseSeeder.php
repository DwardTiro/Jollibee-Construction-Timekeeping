<?php

use Illuminate\Database\Seeder;
use Illuminate\Database\Eloquent\Model;

class DatabaseSeeder extends Seeder {

	/**
	 * Run the database seeds.
	 *
	 * @return void
	 */
	public function run()
	{
		Model::unguard();
		
			DB::table('users')->insert(
        	[
        	'id'=>'2',
            'name'=>'jetj',
        	'user'=>'jet2',
        	'password'=>Hash::make('123'),
        	]);


	}

}

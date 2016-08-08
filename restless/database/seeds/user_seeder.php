<?php

use Illuminate\Database\Seeder;

class user_seeder extends Seeder
{
    /**
     * Run the database seeds.
     *
     * @return void
     */
    public function run()
    {
            DB::table('users')->insert(
        	[
        	'id'=>'2',
            'name'=>'jetj',
        	'user'=>'jet',
        	'password'=>Hash::make('123'),
        	]);
    }
}

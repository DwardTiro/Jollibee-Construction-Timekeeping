<?php namespace App;

use Illuminate\Database\Eloquent\Model;

class employee extends Model {

	//

	protected $table = 'employee';
	protected $primaryKey = 'emp_id'; 
	public $timestamps = false;
	 protected $fillable = array('id_number','first_name', 'last_name','middle_name','salary','project_id');

}

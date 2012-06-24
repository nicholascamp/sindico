define(
	'models/Cep',
	[
		'core/Model',
		'core/utils/ObjectUtils'
	],
	function(Model, ObjectUtils){

		'use strict';

		var AparelhoModel;
  		return AparelhoModel = (function(_super) {
  			ObjectUtils.extend(AparelhoModel, _super);

  			// AparelhoModel :: Constructor
	  		function AparelhoModel() {
		      AparelhoModel.__super__.constructor.apply(this, arguments);
		    }

		    _.extend(AparelhoModel.prototype, {
		    	urlRoot: '/sigie/service/aparelho',
		    })

		    // Export the Model
		    return AparelhoModel;
  		})(Model);

	}
);
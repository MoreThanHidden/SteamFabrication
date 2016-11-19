package morethanhidden.steamfabrication.Client;


import morethanhidden.steamfabrication.common;

public class ClientProxy extends common {
	
	public static int renderPass;
	public static int GemOreRenderType;
	
	@Override
		public void registerRenderers() {

		//Register Item Models
		ItemModelRegistry.init();


	}
	

}

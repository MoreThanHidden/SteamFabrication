package morethanhidden.steamfabrication.blocks;

import morethanhidden.steamfabrication.SteamFabrication;
import morethanhidden.steamfabrication.blocks.tiles.TilePipe;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fluids.capability.IFluidHandler;

public class BlockPipe extends BlockContainer {

    public static final PropertyBool UP = PropertyBool.create("up");
    public static final PropertyBool DOWN = PropertyBool.create("down");
    public static final PropertyBool NORTH = PropertyBool.create("north");
    public static final PropertyBool SOUTH = PropertyBool.create("south");
    public static final PropertyBool EAST = PropertyBool.create("east");
    public static final PropertyBool WEST = PropertyBool.create("west");

    public BlockPipe() {
        super(Material.WEB);
        setCreativeTab(SteamFabrication.tabsteamfabrication);
        setUnlocalizedName("fluid_pipe");
        this.setDefaultState(this.blockState.getBaseState().withProperty(UP, false).withProperty(DOWN, false).withProperty(NORTH, false).withProperty(SOUTH, false).withProperty(EAST, false).withProperty(WEST, false));
    }

    public String getUnlocalizedName() {
        return super.getUnlocalizedName().substring(5);
    }

    @Override
    public boolean isOpaqueCube(IBlockState state) {
        return false;
    }

    @Override
    public EnumBlockRenderType getRenderType(IBlockState state)
    {
        return EnumBlockRenderType.MODEL;
    }

    @Override
    protected BlockStateContainer createBlockState()
    {
        return new BlockStateContainer(this, UP, DOWN, NORTH, SOUTH, EAST, WEST);
    }

    @Override
    public int getMetaFromState(IBlockState state) {
        return 0;
    }

    @Override
    public IBlockState getStateFromMeta(int meta) {
        return getDefaultState();
    }

    @Override
    public IBlockState getActualState(IBlockState state, IBlockAccess worldIn, BlockPos pos)
    {
        return state.withProperty(UP, canConnect(worldIn, pos, EnumFacing.UP))
                .withProperty(DOWN, canConnect(worldIn, pos, EnumFacing.DOWN))
                .withProperty(NORTH, canConnect(worldIn, pos, EnumFacing.NORTH))
                .withProperty(SOUTH, canConnect(worldIn, pos, EnumFacing.SOUTH))
                .withProperty(EAST, canConnect(worldIn, pos, EnumFacing.EAST))
                .withProperty(WEST, canConnect(worldIn, pos, EnumFacing.WEST));
    }

    public final boolean canConnect(IBlockAccess world, BlockPos pos, EnumFacing dir)
    {
        TileEntity tile = world.getTileEntity(pos.offset(dir));
        if (tile != null){
            if (IFluidHandler.class.isAssignableFrom(tile.getClass())){
                return true;
            }
        }
        return false;
    }

    @Override
    public Block setCreativeTab(CreativeTabs tab) {
        super.setCreativeTab(tab);
        return this;
    }

    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta) {
        return new TilePipe();
    }
}






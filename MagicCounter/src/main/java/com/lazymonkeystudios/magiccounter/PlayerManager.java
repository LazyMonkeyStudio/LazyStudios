package com.lazymonkeystudios.magiccounter;

import java.util.List;

/**
 * Created by Mobil HQ on 12/15/2015.
 */
public class PlayerManager {
    public static List<Player> playerList;
    int defaultPlayers = 2;
    public PlayerManager()
    {
        addPlayer(defaultPlayers);
    }

    public void addPlayer(int playerCount)
    {
        for(int i =1;i<playerCount;i++)
        {
            int x = playerList.get(i-1).x;//need to add width to this
            int y = playerList.get(i-1).y;
            playerList.add(new Player("Player"+i,determineX(i,playerCount),y));
        }
        updatePos();
    }
    public int determineX(int i,int playerCount)
    {
        int x = 0;
        if(playerCount<=3)
        {
            //place them on top of each other, 3 high
        }else
        {
            //place them side by side in rows
        }
        return x;
    }
    public void removePlayer(Player player)
    {
        playerList.remove(player);
        updatePos();
    }
    public void updatePos()
    {
        int playerCount = playerList.size();
        for (Player p:playerList)
        {

        }
    }

}

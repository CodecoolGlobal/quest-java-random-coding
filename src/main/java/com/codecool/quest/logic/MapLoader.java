package com.codecool.quest.logic;

import com.codecool.quest.logic.actors.*;
import com.codecool.quest.logic.items.Crown;
import com.codecool.quest.logic.items.Rod;
import com.codecool.quest.logic.items.Sword;
import com.codecool.quest.logic.items.Key;
import java.io.InputStream;
import java.util.Scanner;

public class MapLoader {
    public static GameMap loadMap() {
        InputStream is = MapLoader.class.getResourceAsStream("/map.txt");
        Scanner scanner = new Scanner(is);
        int width = scanner.nextInt();
        int height = scanner.nextInt();

        scanner.nextLine(); // empty line

        GameMap map = new GameMap(width, height, CellType.EMPTY);
        for (int y = 0; y < height; y++) {
            String line = scanner.nextLine();
            for (int x = 0; x < width; x++) {
                if (x < line.length()) {
                    Cell cell = map.getCell(x, y);
                    switch (line.charAt(x)) {
                        case ' ':
                            cell.setType(CellType.EMPTY);
                            break;
                        case '#':
                            cell.setType(CellType.WALL);
                            break;
                        case '.':
                            cell.setType(CellType.FLOOR);
                            break;
                        case 'd':
                            cell.setType(CellType.DOOR);
                            break;
                        case 's':
                            cell.setType(CellType.FLOOR);
                            new Skeleton(cell);
                            break;
                        case '@':
                            cell.setType(CellType.FLOOR);
                            map.setPlayer(new Player(cell));
                            break;
                        case 'w':
                            cell.setType(CellType.FLOOR);
                            cell.setItem(new Sword(cell));
                            break;
                        case 'r':
                            cell.setType(CellType.FLOOR);
                            cell.setItem(new Rod(cell));
                            break;
                        case 'k':
                            cell.setType(CellType.FLOOR);
                            cell.setItem(new Key(cell));
                            break;
                        case 'c':
                            cell.setType(CellType.FLOOR);
                            cell.setItem(new Crown(cell));
                            break;
                        case 'p':
                            cell.setType(CellType.FLOOR);
                            new Spider(cell);
                            break;
                        case 'g':
                            cell.setType(CellType.FLOOR);
                            new Goblin(cell);
                            break;
                        case 'f':
                            cell.setType(CellType.TREE);
                            break;
                        case 'a':
                            cell.setType(CellType.FOOD);
                            break;
                        case 'i':
                            cell.setType(CellType.RIVER);
                            break;
                        case 'b':
                            cell.setType(CellType.FLOOR);
                            new Boss(cell);
                            break;
                        case 'u':
                            cell.setType(CellType.SKULL);
                            break;
                        case 'e':
                            cell.setType(CellType.WEB);
                            break;
                        case 't':
                            cell.setType(CellType.TURN);
                            break;
                        case 'z':
                            cell.setType(CellType.CIRCLE);
                            break;

                        default:
                            throw new RuntimeException("Unrecognized character: '" + line.charAt(x) + "'");
                    }
                }
            }
        }
        return map;
    }

}

package zenas;

import java.awt.datatransfer.ClipboardOwner;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Paul on 9/2/2015.
 */
    public class FileListTransferable implements Transferable, ClipboardOwner {

        private List<File> list;

        public FileListTransferable(List<File> list) {
            this.list = list;
        }

        @Override
        public Object getTransferData(DataFlavor flavor)
                throws UnsupportedFlavorException, IOException {

            if (flavor == DataFlavor.javaFileListFlavor) {
                return list;
            }

            return new UnsupportedFlavorException(flavor);
        }

        @Override
        public DataFlavor[] getTransferDataFlavors() {
            DataFlavor[] dataFlavors = new DataFlavor[1];
            dataFlavors[0] = DataFlavor.javaFileListFlavor;
            return dataFlavors;
        }

        @Override
        public boolean isDataFlavorSupported(DataFlavor flavor) {

            if (flavor == DataFlavor.javaFileListFlavor) {
                return true;
            }

            return false;
        };

        @Override
        public void lostOwnership(java.awt.datatransfer.Clipboard clipboard,
                                  Transferable contents) {

        };

    }

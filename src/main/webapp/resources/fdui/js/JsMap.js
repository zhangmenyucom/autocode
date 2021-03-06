/**
 * @private
 * 存放JS的路径以及依赖项
 */
FDLib.JsMap = {
    FDCalender: {
        path: 'FDCalendar/FDCalendar.js'
        , require: ['FDButton', 'FDControl', 'JString', 'FDLib.date', 'FDLib.util', 'FDLib.dom', 'FDLib.event', 'FDTag', 'FDSelectBox']
    }
    , FDControl: {path: 'FDControl/FDControl.js'}
    , FDField: {path: 'FDForm/interface/FDField.js'}
    , FDItem: {path: 'FDForm/interface/FDItem.js'}
    , FDButton: {
        path: 'FDForm/FDButton.js'
        , require: ['FDFieldComponent']
    }
    , FDCheckBox: {
        path: 'FDForm/FDCheckBox.js'
        , require: ['FDItemComponent']
    }
    , FDComponent: {
        path: 'FDForm/FDComponent.js'
        , require: ['FDControl', 'FDLib.util', 'FDLib.dom']
    }
    , FDDatePick: {
        path: 'FDForm/FDDatePick.js'
        , require: ['FDTextBox', 'FDCalender', 'FDLib.date']
    }
    , FDFieldComponent: {
        path: 'FDForm/FDFieldComponent.js'
        , require: ['FDField', 'FDComponent', 'FDLib.event', 'FDTag', 'FDValidate']
    }
    , FDFormPanel: {
        path: 'FDForm/FDFormPanel.js'
        , require: ['FDButton', 'FDCheckBox', 'FDDatePick'
            , 'FDHidden', 'FDPasswordBox', 'FDRadio'
            , 'FDSelectBox', 'FDTextArea', 'FDTextBox']
    }
    , FDHidden: {
        path: 'FDForm/FDHidden.js'
        , require: ['FDFieldComponent']
    }
    , FDItemComponent: {
        path: 'FDForm/FDItemComponent.js'
        , require: ['FDItem', 'FDFieldComponent', 'FDLib.string', 'JString']
    }
    , FDPasswordBox: {
        path: 'FDForm/FDPasswordBox.js'
        , require: ['FDTextBox']
    }
    , FDRadio: {
        path: 'FDForm/FDRadio.js'
        , require: ['FDItemComponent']
    }
    , FDSelectBox: {
        path: 'FDForm/FDSelectBox.js'
        , require: ['FDItemComponent']
    }
    , FDTextArea: {
        path: 'FDForm/FDTextArea.js'
        , require: ['FDTextBox']
    }
    , FDTextBox: {
        path: 'FDForm/FDTextBox.js'
        , require: ['FDFieldComponent']
    }
    , FDGrid: {
        path: 'FDGrid/FDGrid.js'
        , require: ['FDCheckBox', 'Model', 'View', 'GlobalParams', 'FDLib.util', 'FDLib.dom']
    }
    , Cell: {path: 'FDGrid/interface/Cell.js'}
    , Model: {path: 'FDGrid/interface/Model.js'}
    , View: {path: 'FDGrid/interface/View.js'}
    , FDModel: {
        path: 'FDGrid/model/FDModel.js'
        , require: ['Model', 'FDLib.ajax']
    }
    , FDButtonView: {
        path: 'FDGrid/view/FDButtonView.js'
        , require: ['FDCellView']
    }
    , FDCellView: {
        path: 'FDGrid/view/FDCellView.js'
        , require: ['Cell', 'FDLib.util', 'FDLib.dom']
    }
    , FDHeadCellView: {
        path: 'FDGrid/view/FDHeadCellView.js'
    }
    , FDHeadView: {
        path: 'FDGrid/view/FDHeadView.js'
        , require: ['FDCellView', 'FDSelectHeadCellView']
    }
    , FDPaginationView: {
        path: 'FDGrid/view/FDPaginationView.js'
        , require: ['FDSettingView', 'FDSelectBox']
    }
    , FDRowSelectView: {
        path: 'FDGrid/view/FDRowSelectView.js'
        , require: ['FDCellView', 'FDLib.dom']
    }
    , FDSelectHeadCellView: {
        path: 'FDGrid/view/FDSelectHeadCellView.js'
        , require: ['FDHeadCellView', 'FDLib.util']
    }
    , FDSettingView: {
        path: 'FDGrid/view/FDSettingView.js'
        , require: ['FDWindow', 'FDTab']
    }
    , FDTableView: {
        path: 'FDGrid/view/FDTableView.js'
        , require: ['FDButtonView', 'FDHeadView', 'FDPaginationView', 'FDRowSelectView', 'FDSelectBox']
    }
    , GlobalParams: {
        path: 'FDGrid/GlobalParams.js'
        , require: ['FDTableView', 'FDModel']
    }
    , 'FDLib.ajax': {path: 'FDLib/FDLib.ajax.js'}
    , 'FDLib.browser': {path: 'FDLib/FDLib.browser.js'}
    , 'FDLib.date': {path: 'FDLib/FDLib.date.js'}
    , 'FDLib.dom': {
        path: 'FDLib/FDLib.dom.js'
        , require: ['FDLib.util']
    }
    , 'FDLib.event': {
        path: 'FDLib/FDLib.event.js'
        , require: ['FDLib.browser']
    }
    , 'FDLib.string': {path: 'FDLib/FDLib.string.js'}
    , 'FDLib.util': {path: 'FDLib/FDLib.util.js'}
    , FDTag: {path: 'FDLib/FDTag.js'}
    , JString: {path: 'FDLib/JString.js'}
    , FDPanelDomView: {
        path: 'FDPanel/view/FDPanelDomView.js'
        , require: ['FDLib.util', 'FDLib.dom', 'FDLib.string']
    }
    , FDPanel: {
        path: 'FDPanel/FDPanel.js'
        , require: ['FDControl', 'FDLib.util', 'FDPanelDomView']
    }
    , FDTabView: {
        path: 'FDTab/view/FDTabView.js'
        , require: ['FDLib.util', 'FDLib.string', 'FDLib.event']
    }
    , FDTab: {
        path: 'FDTab/FDTab.js'
        , require: ['FDControl', 'FDTabView', 'FDLib.util', 'FDTag', 'FDLib.dom']
    }
    , FDTip: {
        path: 'FDTip/FDTip.js'
        , require: ['FDControl', 'FDTag', 'FDLib.event', 'FDLib.util']
    }
    , FDTipUtil: {
        path: 'FDTip/FDTipUtil.js'
        , require: ['FDTip']
    }
    , FDTreeDomView: {
        path: 'FDTree/view/FDTreeDomView.js'
        , require: ['FDTag']
    }
    , FDTree: {
        path: 'FDTree/FDTree.js'
        , require: ['FDTreeDomView', 'FDControl', 'FDLib.util', 'FDLib.ajax', 'JString', 'FDLib.event', 'FDLib.dom']
    }
    , FDValidate: {
        path: 'FDValidate/FDValidate.js'
        , require: ['FDValidateStore', 'FDLib.util']
    }
    , FDValidateStore: {path: 'FDValidate/FDValidateStore.js'}
    , FDWindowDomView: {
        path: 'FDWindow/view/FDWindowDomView.js'
        , require: ['FDPanelDomView', 'FDDragUtil', 'JString']
    }
    , FDDragUtil: {path: 'FDWindow/FDDragUtil.js'}
    , FDWindow: {
        path: 'FDWindow/FDWindow.js'
        , require: ['FDPanel', 'FDWindowDomView', 'FDButton']
    }
}